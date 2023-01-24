package org.minesweeper.model.game.elements;

public class Number extends Cell{
    private int num = 1;

    public Number(int x, int y) {
        super(x, y);
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void incrementNumber(){
        this.num += 1;
    }

}
