package io.michaelcarroll;


public class ConnectionManager {

    static int numberOfConnections = 0;

    public Connection getConnection(String ip, String port) {
        if (numberOfConnections == 10)
            return null;
        numberOfConnections++;
        return new ManagedConnection(ip, port);

    }

    private class ManagedConnection implements Connection {

        String ip;
        String port;
        String protocol = "HTTP";
        boolean isOpen;

        public ManagedConnection(String ip, String port) {
            this.ip = ip;
            this.port = port;
            isOpen = true;
        }


        public String getIP() {
            if(isOpen)
            return ip;
            else
                return "Connection closed";
        }

        public String getPort() {
            if(isOpen)
                return port;
            else
                return "Connection closed";
        }

        public String getProtocol() {
            if(isOpen)
                return protocol;
            else
                return "Connection closed";
        }

        public String connect() {
            return null;
        }

        public void close() {
            numberOfConnections--;
            isOpen = false;
        }
    }
}
