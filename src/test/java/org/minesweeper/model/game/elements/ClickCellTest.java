package org.minesweeper.model.game.elements;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ClickCellTest {

    @Test
    void testUnflagCell() {
        ClickCell clickCell = new ClickCell(2, 3);
        clickCell.unflagCell();
        assertFalse(clickCell.isFlagged());
    }
}

