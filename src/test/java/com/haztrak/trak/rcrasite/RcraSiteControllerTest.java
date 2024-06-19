package com.haztrak.trak.rcrasite;


import com.haztrak.trak.rcrasite.errors.RcraSiteNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
<<<<<<<< HEAD:src/test/java/com/haztrak/trak/rcrasite/RcrainfoSiteControllerTests.java
public class RcrainfoSiteControllerTests {
========
public class RcraSiteControllerTest {
>>>>>>>> b082e6b (rename RcrainfoSite package (and classes) to RcraSite):src/test/java/com/haztrak/trak/rcrasite/RcraSiteControllerTest.java

    @MockBean
    private RcraSiteService service;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void LearningJavaTest() {
        assert (true);
    }

    @Test
    public void Returns404WhenNotFound() {
        when(service.findByEpaId("bad-site-id")).thenThrow(new RcraSiteNotFoundException("bad-site-id"));
        ResponseEntity<String> response = restTemplate.getForEntity("/api/site/bad-site-id", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
