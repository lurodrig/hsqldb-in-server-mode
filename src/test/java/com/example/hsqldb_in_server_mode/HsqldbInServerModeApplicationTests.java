package com.example.hsqldb_in_server_mode;

import com.example.hsqldb_in_server_mode.business.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HsqldbInServerModeApplicationTests {

    private final String BASE_URL = "http://localhost";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void numberOfAccountsIsCorrect() {
        // See data.sql script
        int numberOfAccountsExpected = 21;
        ResponseEntity<Account[]> response = this.restTemplate.getForEntity(BASE_URL + ":" + port + "/accounts",
                Account[].class);
        assertNotNull(response.getBody());
        assertEquals(numberOfAccountsExpected, Arrays.asList(response.getBody()).size(),
                "Result differs from the expected number of accounts");
    }

}
