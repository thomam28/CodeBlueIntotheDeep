package org.firstinspires.ftc.teamcode;

public class Delay {
    private long currentTime;
    // sets button delay duration (in milliseconds)
    private long DELAYDURATION;
    public boolean open;

    public Delay(long delays) {
        // sets currentTime to current time
        currentTime = System.currentTimeMillis();
        open = false;
        DELAYDURATION = delays;
    }

    public boolean delay() {
        // if last button press subtracted by last recorded time is less
        // than the delay duration, return false
        if (System.currentTimeMillis() - currentTime >= DELAYDURATION) {
            currentTime = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }
    }
}
