package org.minesweeper.model.game.elements;

public class ClickCell extends Cell{
    private boolean flagged;
    public ClickCell(int x, int y){
        super(x, y);
        this.flagged = false;
    }

    public boolean isFlagged() {
        return this.flagged;
    }

    public void setFlagged(boolean flag) {
        this.flagged = flag;
    }

    public void flagCell() {
        setFlagged(true);
    }

    public void unflagCell() {
        setFlagged(false);
    }
}
