package test;

import main.ClackClient;

import java.io.IOException;

public class TestClackClient {
    public static void main(String[] args) throws IOException {
        ///ClackClient client0 = new ClackClient("uname","hname", 160);
        ///ClackClient client0 = new ClackClient("friend",null);
        ///ClackClient client0 = new ClackClient(null);
        ClackClient client1 = new ClackClient("douglas", "thomas",1025);
        ClackClient client2 = new ClackClient("douglas", "thomas",1025);
        ClackClient client3 = new ClackClient("daisy", "moore");
        ClackClient client4 = new ClackClient("sam");
        ClackClient client5 = new ClackClient();

        System.out.println("The username of client 1 is " + client1.getUserName());
        System.out.println("The hostname of the server is " + client1.getHostName());
        System.out.println("The port humber is " + client1.getPort());

        if(client1.equals(client2))
            System.out.println("client 1 and client 2 are equal");
        else
            System.out.println("client 1 and client 2 are not equal");

        if(client1.equals(client3))
            System.out.println("client 1 and client 3 are equal");
        else
            System.out.println("client 1 and client 3 are not equal");

        System.out.println("The hash code of client 1 is " + client1.hashCode());
        System.out.println("The hash code of client 2 is " + client2.hashCode());
        System.out.println("The hash code of client 3 is " + client3.hashCode());

        System.out.println(client1);

        client1.start();

    }
}
