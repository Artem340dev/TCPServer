package me.peopleXrCb.tcpserver.threads;

import me.peopleXrCb.tcpserver.Main;
import me.peopleXrCb.tcpserver.managers.FileManager;
import me.peopleXrCb.tcpserver.managers.MathManager;
import me.peopleXrCb.tcpserver.objects.ServerClient;

import java.util.List;

public class ClientConnectionThread extends AbstractThread {
    private ServerClient client;

    public ClientConnectionThread(ServerClient client) {
        super(5);
        this.client = client;
    }

    @Override
    protected void except() throws Exception {
        List<String> phrases = FileManager.readLines(Main.getFile());
        if (phrases.size() > 0) client.sendMessage(phrases.get(MathManager.randomNumber(0, phrases.size()-1)));
    }
}