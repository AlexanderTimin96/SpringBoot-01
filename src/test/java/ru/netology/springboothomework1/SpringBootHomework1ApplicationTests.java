package ru.netology.springboothomework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class SpringBootHomework1ApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private static final GenericContainer<?> devapp = new GenericContainer<>("devapp:latest").withExposedPorts(8080);
    @Container
    private static final GenericContainer<?> prodapp = new GenericContainer<>("prodapp:latest").withExposedPorts(8081);

    @Test
    public void devAppTest() {
        ResponseEntity<String> forEntityFirst = restTemplate.getForEntity("http://localhost:"
                + devapp.getMappedPort(8080) + "/profile", String.class);
        String expected = "Current profile is dev";
        Assertions.assertEquals(expected, forEntityFirst.getBody());
    }

    @Test
    public void prodAppTest() {
        ResponseEntity<String> forEntitySecond = restTemplate.getForEntity("http://localhost:"
                + prodapp.getMappedPort(8081) + "/profile", String.class);
        String expected = "Current profile is production";
        Assertions.assertEquals(expected, forEntitySecond.getBody());
    }

}
