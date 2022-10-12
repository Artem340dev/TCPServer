package me.peopleXrCb.tcpserver.objects;

import me.peopleXrCb.tcpserver.threads.ClientConnectionThread;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServerClient {
    private static List<ServerClient> clients;
    private ClientConnectionThread clientConnectionThread;
    private Socket connection;

    static {
        clients = new ArrayList<>();
    }

    public ServerClient(Socket connection) {
        this.connection = connection;

        this.clientConnectionThread = new ClientConnectionThread(this);
        clientConnectionThread.start();

        clients.add(this);
    }

    public Socket getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            clientConnectionThread.stop();

            clients.remove(this);
        } catch (Exception e) {
        }
    }

    public void sendMessage(String msg) {
        try {
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeUTF(msg);
        } catch (Exception e) {
            this.closeConnection();
        }
    }
}