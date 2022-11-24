package main;

import data.ClackData;

import java.io.*;
import java.net.*;

public class ServerSideClientIO {
    private boolean closeConnection;
    private ClackData dataToSendToClient;
    private ClackData dataToReceiveFromClient;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    private ClackServer server;
    private Socket clientSocket;


}
