package me.peopleXrCb.tcpserver.managers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}