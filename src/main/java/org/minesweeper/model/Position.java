package org.minesweeper.model;

public class Position {
    private int x;
    private int y;

    public Position(int input_x, int input_y){
        this.x = input_x;
        this.y = input_y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addPosition(Position pos){
        this.x += pos.getX();
        this.y += pos.getY();
    }

    public Position goUp(){
        return new Position(x,y-1);
    }

    public Position goDown(){
        return new Position(x,y+1);
    }

    public Position goRight(){
        return new Position(x+1,y);
    }

    public Position goLeft(){
        return new Position(x-1,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode(){
        return this.x;
    }
}
