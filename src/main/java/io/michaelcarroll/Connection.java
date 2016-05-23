package io.michaelcarroll;


public interface Connection {

    String getIP();

    String getPort();

    String getProtocol();

    String connect();

    void close();
}
