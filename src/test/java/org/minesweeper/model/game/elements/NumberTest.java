package org.minesweeper.model.game.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Number;

public class NumberTest {


    public Number helper() {
        return new Number(5, 9);
    }

    @Test
    public void test_getNum() {
        Number num = helper();
        Assertions.assertEquals(num.getNum(), 1);
    }

    @Test
    public void test_setNum() {
        Number num = helper();
        num.setNum(4);
        Assertions.assertEquals(num.getNum(), 4);
    }

    @Test
    public void testConstructor() {
        Number actualNumber = new Number(2, 3);
        actualNumber.incrementNumber();
        assertEquals(2, actualNumber.getNum());
        Position cellPosition = actualNumber.getCellPosition();
        assertEquals(3, cellPosition.getY());
        assertEquals(2, cellPosition.getX());
    }
}
