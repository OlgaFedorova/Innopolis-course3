package ru.innopolis.uni.course3.threads.Task1;

/**
 * Created by Olga on 08.12.2016.
 */
public class ThreadMessage extends Thread {
    private final Time time;
    private final int countForMessage;

    public ThreadMessage(Time time, int countForMessage) {
        this.time = time;
        this.countForMessage = countForMessage;
    }

    private boolean waitTimer() {
        boolean isBreak = false;
        try {
            synchronized (this.time) {
                this.time.wait();
            }
        } catch (InterruptedException e) {
            isBreak = true;
        }
        return isBreak;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            if (this.time.getTime() == 0 || this.time.getTime() % this.countForMessage != 0) {
                if (this.waitTimer()) {
                    break;
                }
            } else {
                System.out.printf("%d second\n", this.countForMessage);
                if (this.waitTimer()) {
                    break;
                }
            }
        }
    }
}
