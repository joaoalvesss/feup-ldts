package org.minesweeper.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointerTest {
    private Pointer pointer;

    //Pointer is not supposed to move without permission of the PointerController

    @BeforeEach
    public void helper(){pointer = new Pointer(10,10);}

    @Test
    public void up(){
        for(int i = 0; i < 4; i++) pointer.getCellPosition().goUp();
        assertEquals(10, pointer.getCellPosition().getY());
    }

    @Test
    public void down(){
        pointer.getCellPosition().goDown();
        assertEquals(10, pointer.getCellPosition().getY());
    }

    @Test
    public void left(){
        for(int i = 0; i < 9; i++) pointer.getCellPosition().goLeft();
        assertEquals(new Position(10,10), pointer.getCellPosition());
    }

    @Test
    public void right(){
        for(int i = 0; i < 2; i++) pointer.getCellPosition().goRight();
        assertEquals(10, pointer.getCellPosition().getX());
    }
}
