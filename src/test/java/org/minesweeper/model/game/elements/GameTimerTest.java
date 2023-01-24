package org.minesweeper.model.game.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameTimerTest {

    @Test
    void testStop() {
        GameTimer gameTimer = new GameTimer();
        gameTimer.stop();
        assertEquals(0, gameTimer.getTime());
    }
}

