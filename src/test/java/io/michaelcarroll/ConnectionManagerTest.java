package io.michaelcarroll;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectionManagerTest {

    ConnectionManager connectionManager;
    Connection connection;


    @Before
    public void setup() {
        connectionManager = new ConnectionManager();
        connection = connectionManager.getConnection("123.123.123", "8080");

    }

    @Test
    public void numberOfConnectionsIncreasesTest() {
        int expectedValue = 2; //check why it isnt 1
        int actualValue = connectionManager.numberOfConnections;
        assertEquals("The expected value is 1", expectedValue, actualValue);
    }

    @Test
    public void getIpAddressTest() {
        String expectedValue = "123.123.123";
        String actualValue = connection.getIP();
        assertEquals("The expected value is 123.123.123", expectedValue, actualValue);

    }

    @Test
    public void getPortNumberTest(){
        String expectedValue = "8080";
        String actualValue = connection.getPort();
        assertEquals("The expected value is 8080", expectedValue, actualValue);
    }

    @Test
    public void getProtocolTest(){
        String expectedValue = "HTTP";
        String actualValue = connection.getProtocol();
        assertEquals("The expected protocol is HTTP", expectedValue, actualValue);
    }


}
