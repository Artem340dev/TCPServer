package me.peopleXrCb.tcpserver.objects;

import me.peopleXrCb.tcpserver.threads.ClientAcceptThread;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ClientAcceptThread clientAcceptThread;
    private ServerSocket socket;

    public Server(int port) throws Exception {
        this.socket = new ServerSocket(port);

        this.clientAcceptThread = new ClientAcceptThread();
        clientAcceptThread.start();
    }

    public ServerSocket getSocket() {
        return socket;
    }
}