package org.minesweeper.model.gameover;

public class GameOver {
    private final int time;
    private final String message;
    protected int numBombs;

    public GameOver(int time, String message) {
        this.time = time;
        this.message = message;
        this.numBombs = 0;
    }

    public int getTime() { return this.time; }

    public String getMessage() {
        return message;
    }

    public int getNumBombs() { return numBombs; }
}
