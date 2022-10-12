package me.peopleXrCb.tcpserver;

import me.peopleXrCb.tcpserver.objects.Server;

import java.io.File;

public class Main {
    private static File file;
    private static Server server;

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(args[0]);
        String filePath = args[1];

        file = new File(filePath);
        server = new Server(port);
        
        System.out.println("[SERVER]: Server has been started.");
    }

    public static Server getServer() {
        return server;
    }

    public static File getFile() {
        return file;
    }
}