package main;

import data.ClackData;

/**
 * The ClackServer class represents the server that clients connect to
 * This class holds data for the server
 */
public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToClient;
    private ClackData dataToReceiveFromClient;
    static final int DEFAULT_PORT_NUMBER = 7000;

    /**
     * This is a constructor for the ClackServer class
     * @param p This is the port number a client connects to
     */
    public ClackServer(int p){
        this.port = p;
        this.closeConnection = false;
        this.dataToSendToClient = null;
        this.dataToReceiveFromClient = null;
    }

    /**
     * This is the default constructor for the ClackServer class
     */
    public ClackServer(){
        this(DEFAULT_PORT_NUMBER);
    }

    public void start(){}

    public void receiveData(ClackData dataFromClient){}

    public void sentData(){}

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
}
