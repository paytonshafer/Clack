package main;

import data.ClackData;

public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;
    static final int DEAFAUT_PORT_NUMBER = 7000;

    public ClackClient(String u, String h, int p){
        this.userName = u;
        this.hostName = h;
        this.port = p;
        this.closeConnection = false;
        this.dataToSendToServer = null;
        this.dataToReceiveFromServer = null;
    }

    public ClackClient(String u, String h){
        this(u,h,DEAFAUT_PORT_NUMBER);
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

    public String getUserName(){
        return userName;
    }

    public String getHostName(){
        return hostName;
    }

    public int getPort(){
        return port;
    }
}
