package test;

import main.ClackServer;

public class TestClackServer {
    public static void main(String args[]) {
        ClackServer server1 = new ClackServer(22);
        ClackServer server2 = new ClackServer(22);
        ClackServer server3 = new ClackServer();

        System.out.println("The port humber is " + server1.getPort());

        if (server1.equals(server2))
            System.out.println("server 1 and server 2 are equal");
        else
            System.out.println("server 1 and server 2 are not equal");

        if (server1.equals(server3))
            System.out.println("server 1 and server 3 are equal");
        else
            System.out.println("server 1 and server 3 are not equal");

        System.out.println("The hash code of server 1 is " + server1.hashCode());
        System.out.println("The hash code of server 2 is " + server2.hashCode());
        System.out.println("The hash code of server 3 is " + server3.hashCode());

        System.out.println(server1);
    }
}
