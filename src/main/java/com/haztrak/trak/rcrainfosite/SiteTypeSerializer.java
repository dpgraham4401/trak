package com.haztrak.trak.rcrainfosite;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

class SiteTypeSerializer extends StdSerializer<SiteType> {
    @Override
    public void serialize(SiteType siteType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeString(siteType.toString());
    }

    public SiteTypeSerializer() {
        super(SiteType.class);
    }
}
