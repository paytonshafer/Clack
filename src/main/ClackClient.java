package main;

import data.ClackData;

public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
    static final int DEFAULT_PORT_NUMBER = 7000;

    public ClackClient(String u, String h, int p){
        this.userName = u;
        this.hostName = h;
        this.port = p;
        this.closeConnection = false;
        this.dataToSendToServer = null;
        this.dataToReceiveFromServer = null;
    }

    public ClackClient(String u, String h){
        this(u,h,DEFAULT_PORT_NUMBER);
    }

    public ClackClient(String u){
        this(u,"localhost");
    }

    public ClackClient(){
        this("anonymous");
    }

    public void start(){}

    public void readClientData(){}

    public void sendData(){}

    public void receiveData(){}

    public void printData(){}

    public String getUserName(){return userName;}

    public String getHostName(){return hostName;}

    public int getPort(){return port;}

    public int hashCode(){return userName.length()*hostName.length()*port;}

    public boolean equals(Object obj){
        ClackClient other = (ClackClient) obj;
        return this.hostName.equals(other.hostName) && this.userName.equals(other.userName) &&
                this.closeConnection == other.closeConnection && this.port == other.port &&
                 this.dataToSendToServer.equals(other.dataToSendToServer) &&
                  this.dataToReceiveFromServer.equals(other.dataToReceiveFromServer);
    }

    public String toString(){
        return "The client's username is" + this.userName + ". The current host Name is " +
                this.hostName + ". The current port number is " + this.port +
                 ". The current status of the connection being closed is " + this.closeConnection +
                  ". The data sent to the server is:\n" + this.dataToSendToServer +
                   "\nThe data received from the server is:\n" + this.dataToReceiveFromServer;
    }
}
