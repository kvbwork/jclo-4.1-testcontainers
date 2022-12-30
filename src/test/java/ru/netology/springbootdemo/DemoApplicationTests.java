package ru.netology.springbootdemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    static final int DEV_PORT = 8080;
    static final int PROD_PORT = 8081;

    static final GenericContainer<?> DEV_APP = new GenericContainer<>("devapp")
            .withExposedPorts(DEV_PORT);

    static final GenericContainer<?> PROD_APP = new GenericContainer<>("prodapp")
            .withExposedPorts(PROD_PORT);

    static String devUrl;
    static String prodUrl;

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    public static void setUp() {
        DEV_APP.start();
        devUrl = String.format("http://%s:%d", DEV_APP.getHost(), DEV_APP.getMappedPort(DEV_PORT));

        PROD_APP.start();
        prodUrl = String.format("http://%s:%d", PROD_APP.getHost(), PROD_APP.getMappedPort(PROD_PORT));
    }

    @Test
    void devapp_get_profile_success() {
        String expectedBody = "Current profile is dev";

        ResponseEntity<String> forEntity = restTemplate.getForEntity(devUrl + "/profile", String.class);
        System.out.println(forEntity.getBody());

        assertEquals(expectedBody, forEntity.getBody());
    }

    @Test
    void prodapp_get_profile_success() {
        String expectedBody = "Current profile is production";

        ResponseEntity<String> forEntity = restTemplate.getForEntity(prodUrl + "/profile", String.class);
        System.out.println(forEntity.getBody());

        assertEquals(expectedBody, forEntity.getBody());
    }

}
