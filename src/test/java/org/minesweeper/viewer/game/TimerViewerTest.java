package org.minesweeper.viewer.game;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.game.elements.GameTimer;

class TimerViewerTest {
    @Test
    void testConstructor() {
        GameTimer gameTimer = new GameTimer();
        assertSame(gameTimer, (new TimerViewer(gameTimer)).getModel());
    }
}

