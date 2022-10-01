package main;

import data.ClackData;

public class ClackServer {
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToClient;
    private ClackData dataToReceiveFromClient;
    static final int DEFAULT_PORT_NUMBER = 7000;

    public ClackServer(int p){
        this.port = p;
        this.closeConnection = false;
        this.dataToSendToClient = null;
        this.dataToReceiveFromClient = null;
    }

    public ClackServer(){
        this(DEFAULT_PORT_NUMBER);
    }

    public void start(){}

    public void receiveData(ClackData dataFromClient){}

    public void sentData(){}

    public int getPort() {return port;}

    public int hashCode(){return port;}

    public boolean equals(Object obj) {
        ClackServer other = (ClackServer) obj;
        return this.port == other.port;
    }

    public String toString(){
        return "The current port number is " + this.port +
                ". The current status of the connection being closed is " + this.closeConnection +
                 ". The data sent to the client is:\n" + this.dataToSendToClient +
                  "\nThe data received from the client is:\n" + this.dataToReceiveFromClient + ".";
    }
}
