package test;

import main.ClackServer;
import java.io.IOException;


public class TestClackServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if(args.length == 0) {
            ClackServer defaultServer = new ClackServer();
            defaultServer.start();
        }else{
            ClackServer server = new ClackServer(Integer.parseInt(args[0]));
            server.start();
        }
    }
}
