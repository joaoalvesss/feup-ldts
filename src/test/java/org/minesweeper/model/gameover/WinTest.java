package org.minesweeper.model.gameover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WinTest {
    @Test
    public void testConstructor() {
        Win actualWin = new Win(1);
        assertEquals("YOU WIN!", actualWin.getMessage());
        assertEquals(1, actualWin.getTime());
        assertEquals(0, actualWin.getNumBombs());
    }
}

