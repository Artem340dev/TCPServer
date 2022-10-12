package me.peopleXrCb.tcpserver.threads;

import me.peopleXrCb.tcpserver.Main;
import me.peopleXrCb.tcpserver.objects.ServerClient;

import java.net.Socket;

public class ClientAcceptThread extends AbstractThread {
    public ClientAcceptThread() {
        super(0);
    }

    @Override
    protected void except() throws Exception {
        Socket connection = Main.getServer().getSocket().accept();
        ServerClient client = new ServerClient(connection);

        System.out.println("[SERVER]: New connection!");
    }
}
