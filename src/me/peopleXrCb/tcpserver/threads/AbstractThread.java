package me.peopleXrCb.tcpserver.threads;

public abstract class AbstractThread extends Thread {
    private int delay;

    public AbstractThread(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.sleep(delay*1000);
                this.except();
            }
        } catch (Exception e) {
        }
    }

    protected abstract void except() throws Exception;
}