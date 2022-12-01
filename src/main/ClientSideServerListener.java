package main;

/**
 * This class constructs a listener object on a separate thread then the main
 * client object. This object handles all data coming from the server, and
 * handles the printing of said data.
 */
public class ClientSideServerListener implements Runnable {

    private ClackClient client;

    /**
     * The sole constructor just needs the client object from ClackClient.
     * @param client
     */
    ClientSideServerListener( ClackClient client) {
        this.client = client;
    }

    /**
     * When the thread is started, it constantly tries to receive data from
     * the server and print it out.
     */
    @Override
    public void run() {
        while (!client.getCloseConnection()) {
            client.receiveData();
            if (client.getCloseConnection()) break;
            client.printData();
        }
    }

}
