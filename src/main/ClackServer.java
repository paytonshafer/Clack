package main;

import data.ClackData;
import data.MessageClackData;
import data.FileClackData;
import java.io.*;
import java.net.*;

/**
 * The ClackServer class represents the server that clients connect to
 * This class holds data for the server
 */
public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToClient;
    private ClackData dataToReceiveFromClient;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
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
        this.dataToSendToClient = null;
        this.dataToReceiveFromClient = null;
        this.inFromClient = null;
        this.outToClient = null;
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
            Socket clientSkt = skt.accept();
            System.out.println("Socket Established");
            inFromClient = new ObjectInputStream(clientSkt.getInputStream());
            outToClient = new ObjectOutputStream(clientSkt.getOutputStream());

            while(!closeConnection){
                receiveData();
                dataToSendToClient = dataToReceiveFromClient;
                sendData();
            }

            skt.close();
            clientSkt.close();
            inFromClient.close();
            outToClient.close();

        }catch(IOException IOE) {
            System.err.println("IO Exception");
        }catch (SecurityException SE){
            System.err.println("Security Exception");
        }catch(IllegalArgumentException IAE){
            System.err.println("Illegal Argument for Port Number");
        }catch(NullPointerException NPE){
            System.err.println("Null Pointer Exception");
        }
    }

    /**
     * This function receives data from inFromClient
     * @throws IOException
     * @throws InvalidClassException
     * @throws ClassNotFoundException
     * @throws StreamCorruptedException
     * @throws OptionalDataException
     */
    public void receiveData(){
        try{
            dataToReceiveFromClient = (ClackData) inFromClient.readObject();

            if (dataToReceiveFromClient.getType() == ClackData.CONSTANT_LOGOUT) {
                closeConnection = true;
            }

        }catch(InvalidClassException ICE){
            System.err.println("Invalid Class Exception");
        }catch(ClassNotFoundException CNF){
            System.err.println("Class Not Found Exception");
        }catch(IOException IOE) {
            System.err.println("IO Exception");
        }
    }

    /**
     * This function sends data to the client with outToClient
     * @throws InvalidClassException
     * @throws NotSerializableException
     * @throws IOException
     */
    public void sendData() throws InvalidClassException, NotSerializableException, IOException {
        try{
            outToClient.writeObject(dataToSendToClient);
        }catch(InvalidClassException ICE){
            System.err.println("Invalid Class Exception");
        }catch(NotSerializableException NSE){
            System.err.println("Not Serializable Exception");
        }catch(IOException IOE){
            System.err.println("IO Exception");
        }
    }

    /**
     * This functions returns the port number
     * @return This returns the port number
     */
    public int getPort() {return port;}

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
                ". The current status of the connection being closed is " + this.closeConnection +
                 ". The data sent to the client is:\n" + this.dataToSendToClient +
                  "\nThe data received from the client is:\n" + this.dataToReceiveFromClient + ".";
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
