package org.minesweeper.controller.gameover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.gameover.GameOver;

class GameOverControllerTest {

    @Test
    void testConstructor() {
        GameOver gameOver = new GameOver(1, "YOU LOST");

        GameOver model = (new GameOverController(gameOver)).getModel();
        assertSame(gameOver, model);
        assertEquals("YOU LOST", model.getMessage());
        assertEquals(1, model.getTime());
        assertEquals(0, model.getNumBombs());
    }
}

