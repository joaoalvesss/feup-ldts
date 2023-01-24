package org.minesweeper.model.game.elements;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    private int time;
    private final Timer timer = new Timer();

    TimerTask update = new TimerTask() {
        @Override
        public void run() {
            time++;
        }
    };

    public GameTimer() {
        this.time = 0;
        timer.scheduleAtFixedRate(update, 0, 1000);
    }

    public int getTime() { return this.time; }

    public void stop() { timer.cancel(); }
}
