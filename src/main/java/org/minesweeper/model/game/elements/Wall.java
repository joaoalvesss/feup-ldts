package org.minesweeper.model.game.elements;

public class Wall extends Cell{
    private final String location;
    public Wall(int x, int y, String location) {
        super(x, y);
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}
