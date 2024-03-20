package com.haztrak.trak.rcrainfosite;


import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SiteTypeSerializerTests {


    @Test
    public void serializeWritesSiteTypeToString() throws IOException {
        // Arrange
        SiteType siteType = SiteType.Generator;
        SiteTypeSerializer serializer = new SiteTypeSerializer();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);

        // Act
        serializer.serialize(siteType, jsonGenerator, null);

        // Assert
        verify(jsonGenerator).writeString(siteType.toString());
    }

    @Test
    public void serializeThrowsIOExceptionWhenWriteFails() throws IOException {
        // Arrange
        SiteType siteType = SiteType.Generator;
        SiteTypeSerializer serializer = new SiteTypeSerializer();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        doThrow(new IOException()).when(jsonGenerator).writeString(anyString());

        // Act & Assert
        assertThrows(IOException.class, () -> serializer.serialize(siteType, jsonGenerator, null));
    }
}