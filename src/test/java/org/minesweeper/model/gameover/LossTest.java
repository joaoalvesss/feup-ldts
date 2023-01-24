package org.minesweeper.model.gameover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LossTest {
    @Test
    public void testConstructor() {
        Loss actualLoss = new Loss(1, 10);

        assertEquals("YOU LOST!", actualLoss.getMessage());
        assertEquals(1, actualLoss.getTime());
        assertEquals(10, actualLoss.getNumBombs());
    }
}

