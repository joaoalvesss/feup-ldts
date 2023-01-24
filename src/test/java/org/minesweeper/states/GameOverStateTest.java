package org.minesweeper.states;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.minesweeper.model.gameover.GameOver;

class GameOverStateTest {
    @Test
    void testConstructor() {
        GameOver gameOver = new GameOver(1, "YOU LOST");
        assertSame(gameOver, (new GameOverState(gameOver)).getModel());
    }

    @Test
    void testGetViewer() {
        GameOver gameOver = new GameOver(1, "LOST!");
        assertSame(gameOver, (new GameOverState(gameOver)).getViewer().getModel());
    }

    @Test
    void testGetController() {
        GameOver model = (new GameOverState(new GameOver(1, "RAndom"))).getController().getModel();
        assertEquals("RAndom", model.getMessage());
        assertEquals(1, model.getTime());
        assertEquals(0, model.getNumBombs());
    }
}

