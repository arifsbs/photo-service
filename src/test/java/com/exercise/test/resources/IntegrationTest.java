package com.exercise.test.resources;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sysdeva5 on 12/10/2016.
 */
public class IntegrationTest {

    private Client client;

    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }

    @Test
    public void testHelloWorld() throws Exception {

        /*client.target("http://localhost:" + RULE.getLocalPort() + "/photo-album")
                .request()
                .get();*/

        assertThat("test").isEqualTo("test");

    }
}
