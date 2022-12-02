package main;

import data.ClackData;
import data.MessageClackData;
import data.FileClackData;
import main.ServerSideClientIO;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * The ClackServer class represents the server that clients connect to
 * This class holds data for the server
 */
public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ArrayList<ServerSideClientIO> serverSideClientIOList;
    static final int DEFAULT_PORT_NUMBER = 1200;

    /**
     * This is a constructor for the ClackServer class
     * @param p This is the port number a client connects to
     */
    public ClackServer(int p) throws IllegalArgumentException{
        if(p < 1024){
            throw new IllegalArgumentException("Your provided port number is less than 1024");
        }
        this.port = p;
        this.closeConnection = false;
        this.serverSideClientIOList = new ArrayList<ServerSideClientIO>();
    }

    /**
     * This is the default constructor for the ClackServer class
     */
    public ClackServer(){
        this(DEFAULT_PORT_NUMBER);
    }

    /**
     * This function starts and runs the server
     */
    public void start() {
        try {
            ServerSocket skt = new ServerSocket(port);

            while(!closeConnection){
                Socket clientSkt = skt.accept();
                String userName = "bill";
                //String userName = new BufferedReader(new InputStreamReader(clientSkt.getInputStream())).readLine();
                System.out.println(userName);
                ServerSideClientIO client = new ServerSideClientIO(this, clientSkt, userName);
                System.out.println(client.toString());
                serverSideClientIOList.add(client);
                Thread thread = new Thread(client);
                thread.start();
            }

            skt.close();

        }catch(IOException IOE) {
            System.err.println("IO Exception in start() in ClarkServer");
        }catch (SecurityException SE){
            System.err.println("Security Exception");
        }catch(IllegalArgumentException IAE){
            System.err.println("Illegal Argument for Port Number");
        }catch(NullPointerException NPE){
            System.err.println("Null Pointer Exception");
        }
    }

    /**
     * This function broadcasts the data to all current clients
     * @param dataToBroadcastToClients is a ClackData object of data to send to call clients
     */
    public synchronized void broadcast(ClackData dataToBroadcastToClients){
        for(ServerSideClientIO client : serverSideClientIOList){
            client.setDataToSendToClient(dataToBroadcastToClients);
            client.sendData();
        }
    }

    /**
     * This function will remove a client from the client list when their connection is ended
     * @param client is a ServerSideClientIO object to be removed from the list of current clients
     */
    public void remove(ServerSideClientIO client){
        serverSideClientIOList.remove(client);
    }

    /**
     * This functions returns the port number
     * @return This returns the port number
     */
    public int getPort() {return port;}

    /**
     * This function returns a formatted string listing all every clients Username.
     * @return
     */
    public String getList() {

        String list = null;

        for (ServerSideClientIO client : serverSideClientIOList) {
                list = client.getUserName() + "\n";
        }

        return list;
    }

    /**
     * This is a function to override hash code for the ClackServer object
     * @return This returns a hash code such that equal objects have the same hash code
     */
    public int hashCode(){return port;}

    /**
     * This is a function to override the equals function for the ClackServer object
     * @param obj This represents the other object the server is being compared to
     * @return This returns true or false for whether the servers are equal
     */
    public boolean equals(Object obj) {
        ClackServer other = (ClackServer) obj;
        return this.port == other.port;
    }

    /**
     * This is a function to override the toString function for the ClackServer object
     * @return This returns the server as a string such that it can be printed out
     */
    public String toString(){
        return "The current port number is " + this.port +
                ". The current status of the connection being closed is " + this.closeConnection + ".";
    }

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
    public static void main(String[] args)  {
        if(args.length == 0) {
            ClackServer defaultServer = new ClackServer();
            defaultServer.start();
        }else{
            ClackServer server = new ClackServer(Integer.parseInt(args[0]));
            server.start();
        }
    }
}
