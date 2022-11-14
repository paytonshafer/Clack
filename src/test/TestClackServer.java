package test;

import main.ClackServer;
import java.io.IOException;

/**
 * This is a main method for ClackServer.
 *
 * If ClackServer is called with no arguments it creates a
 * connection with the default port number
 *
 * If ClackServer is called with an argument, it will take
 * the information from the argument and put the information
 * into the constructor of the server. The argument syntax is
 * as follows: <PORT>
 *
 * @param args
 */
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
