package org.minesweeper.model.gameover;

public class Loss extends GameOver {

    public Loss(int time, int numBombs) {
        super(time, "YOU LOST!");
        this.numBombs = numBombs;
    }
}

