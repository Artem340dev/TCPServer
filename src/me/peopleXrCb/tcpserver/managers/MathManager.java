package me.peopleXrCb.tcpserver.managers;

public class MathManager {
    public static int randomNumber(int min, int max) {
        int range = max - min;
        return (int) (Math.random() * range) + min;
    }
}