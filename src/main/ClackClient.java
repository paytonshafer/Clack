package main;

import data.ClackData;

/**
 * The ClackClient class represents the client user
 * The class holds the data of the client
 */
public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
    static final int DEFAULT_PORT_NUMBER = 7000;

    /**
     * This is a constructor for the ClackClient class
     * @param u This is the username for the client
     * @param h This is the hostname the client is connected to
     * @param p This is the port number the client is connected to
     */
    public ClackClient(String u, String h, int p){
        this.userName = u;
        this.hostName = h;
        this.port = p;
        this.closeConnection = false;
        this.dataToSendToServer = null;
        this.dataToReceiveFromServer = null;
    }

    /**
     * This is a constructor for the ClackClient class
     * @param u This is the username for the client
     * @param h This is the hostname the client is connected to
     */
    public ClackClient(String u, String h){
        this(u,h,DEFAULT_PORT_NUMBER);
    }

    /**
     * This is a constructor for the ClackClient class
     * @param u This is the username for the client
     */
    public ClackClient(String u){
        this(u,"localhost");
    }

    /**
     * This is the default constructor
     */
    public ClackClient(){
        this("anonymous");
    }

    public void start(){}

    public void readClientData(){}

    public void sendData(){}

    public void receiveData(){}

    public void printData(){}

    /**
     * This functions returns the clients username
     * @return This returns the clients username
     */
    public String getUserName(){return userName;}

    /**
     * This functions returns the clients hostname
     * @return This returns the clients hostname
     */
    public String getHostName(){return hostName;}

    /**
     * This functions returns the clients port
     * @return This returns the clients port
     */
    public int getPort(){return port;}

    /**
     * This is a function to override hash code for the ClackClient object
     * @return This returns a hash code such that equal objects have the same hash code
     */
    public int hashCode(){return userName.hashCode()*hostName.hashCode()*port;}

    /**
     * This is a function to override the equals function for the ClackClient object
     * @param obj This represents the other object the client is being compared to
     * @return This returns true or false for whether the clients are equal
     */
    public boolean equals(Object obj){
        ClackClient other = (ClackClient) obj;
        return this.hostName.equals(other.hostName) && this.userName.equals(other.userName) &&
                this.port == other.port;
    }

    /**
     * This is a function to override the toString function for the ClackClient object
     * @return This returns the client as a string such that it can be printed out
     */
    public String toString(){
        return "The client's username is " + this.userName + ".\nThe current host Name is " +
                this.hostName + ".\nThe current port number is " + this.port +
                 ".\nThe current status of the connection being closed is " + this.closeConnection +
                  ".\nThe data sent to the server is:\n" + this.dataToSendToServer +
                   "\nThe data received from the server is:\n" + this.dataToReceiveFromServer;
    }
}
