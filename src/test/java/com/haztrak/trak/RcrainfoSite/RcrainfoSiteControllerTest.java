package com.haztrak.trak.RcrainfoSite;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RcrainfoSiteControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void LearningJavaTest() {
        assert (true);
    }

    @Test
    public void Returns404WhenNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/site/bad-site-id", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
