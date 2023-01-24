package org.minesweeper.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Cell;

public class CellTest {

    public Cell helper(){
        return new Cell(5,7);
    }

    @Test
    public void test_get_cell_position(){
        Cell cell = helper();

        Assertions.assertEquals(cell.getCellPosition().getX(), 5);
        Assertions.assertEquals(cell.getCellPosition().getY(), 7);
    }

    @Test
    public void test_set_cell_position(){
        Cell cell = helper();
        cell.setCellPosition(new Position(10, 11));
        
        Assertions.assertEquals(cell.getCellPosition().getX(), 10);
        Assertions.assertEquals(cell.getCellPosition().getY(), 11);
    }
}
