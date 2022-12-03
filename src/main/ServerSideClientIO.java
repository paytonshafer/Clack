package main;

import data.ClackData;
import data.MessageClackData;

import java.io.*;
import java.net.*;

public class ServerSideClientIO implements Runnable {
    private boolean closeConnection;
    private ClackData dataToSendToClient;
    private ClackData dataToReceiveFromClient;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    private ClackServer server;
    private Socket clientSocket;
    private String userName = "";
    static final String KEY = "xicvpowcndsiufycn";

    public ServerSideClientIO(ClackServer server, Socket clientSocket){
        this.server = server;
        this.clientSocket = clientSocket;
        this.closeConnection = false;
        this.dataToReceiveFromClient = null;
        this.dataToSendToClient = null;
        this.inFromClient = null;
        this.outToClient = null;
    }

    public void run(){
        try {
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

        while(!closeConnection) {
            receiveData();
            if (closeConnection)break;
            if (dataToReceiveFromClient.getType() == ClackData.CONSTANT_LISTUSERS) continue;
            server.broadcast(dataToReceiveFromClient);
        }

        clientSocket.close();
        server.remove(this);
        } catch (IOException e) {
            System.err.println("IO Exception in run() in ClientIO");
        }
    }

    /**
     * This function receives data from inFromClient
     */
    public void receiveData() {
        try {

            dataToReceiveFromClient = (ClackData) inFromClient.readObject();

            if (this.userName.isEmpty()) this.userName = dataToReceiveFromClient.getUserName();

            if(dataToReceiveFromClient.getType() == ClackData.CONSTANT_LOGOUT){
                closeConnection = true;
                server.remove(this);
                return;
            }
            if (dataToReceiveFromClient.getType() == ClackData.CONSTANT_LISTUSERS) {
                  outToClient.writeObject(new MessageClackData ("Server", server.getList(), KEY, 2));
            }

        } catch (InvalidClassException ICE) {
            System.err.println("Invalid Class Exception");
        } catch (ClassNotFoundException CNF) {
            System.err.println("Class Not Found Exception");
        } catch (IOException IOE) {
            System.err.println("IO Exception");
        }
    }

    /**
     * This function sends data to the client
     */
    public void sendData(){
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

    public void setDataToSendToClient(ClackData dataToSendToClient) {
        this.dataToSendToClient = dataToSendToClient;
    }

    /**
     * Getter function for variable userName.
     * @return
     */
    public String getUserName() {
        return userName;
    }
}
