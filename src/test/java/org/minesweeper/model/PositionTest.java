package org.minesweeper.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    
    public Position helper(){
        Position pos = new Position(5, 7);
        return pos;
    }

    @Test
    public void test_getX(){
        Position pos = helper();

        assertEquals(pos.getX(), 5);
    }

    @Test
    public void test_getY(){
        Position pos = helper();

        assertEquals(pos.getY(), 7);
    }

    @Test
    public void test_setX(){
        Position pos = helper();
        pos.setX(3);
        Position expected = new Position(3,7);
        assertEquals(pos, expected);
    }

    @Test
    public void test_setY(){
        Position pos = helper();
        pos.setY(10);
        Position expected = new Position(5,10);
        assertEquals(pos, expected);
    }

    @Property
    public void goLeft(@ForAll int x, @ForAll int y){
        assertEquals(x-1, new Position(x,y).goLeft().getX());
        assertEquals(y, new Position(x,y).goLeft().getY());
    }

    @Property
    public void goUp(@ForAll int x, @ForAll int y){
        assertEquals(y-1, new Position(x,y).goUp().getY());
        assertEquals(x, new Position(x,y).goUp().getX());
    }

    @Property
    public void goDown(@ForAll int x, @ForAll int y){
        assertEquals(y+1, new Position(x,y).goDown().getY());
        assertEquals(x, new Position(x,y).goDown().getX());
    }

    @Property
    public void goRight(@ForAll int x, @ForAll int y){
        assertEquals(x+1, new Position(x,y).goRight().getX());
        assertEquals(y, new Position(x,y).goLeft().getY());
    }
}
