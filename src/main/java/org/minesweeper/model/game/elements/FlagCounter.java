package org.minesweeper.model.game.elements;

public class FlagCounter {
    private int counter;

    public FlagCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() { return this.counter; }

    public void increment() { this.counter++; }

    public void decrement() { this.counter--; }
}
