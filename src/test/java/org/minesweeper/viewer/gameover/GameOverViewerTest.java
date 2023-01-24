package org.minesweeper.viewer.gameover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.gameover.GameOver;
import org.minesweeper.model.gameover.Loss;
import org.minesweeper.model.gameover.Win;
import org.minesweeper.viewer.menu.MenuBoxViewer;
import org.mockito.Mockito;

public class GameOverViewerTest {

    @Test
    void testConstructor() {
        GameOver gameOver = new GameOver(1, "YOU LOST!");
        GameOver model = (new GameOverViewer(gameOver)).getModel();
        assertSame(gameOver, model);
        assertEquals("YOU LOST!", model.getMessage());
        assertEquals(1, model.getTime());
        assertEquals(0, model.getNumBombs());
    }

    @Test
    void drawElementsLossTest() {
        GameOverViewer gameOverViewer = new GameOverViewer(new Loss(1, 10));
        GUI gui = Mockito.mock(LanternaGUI.class);
        gameOverViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(57)).drawText(any(Position.class), anyString(), anyString());
    }

    @Test
    void drawElementsWinTest() {
        GameOverViewer gameOverViewer = new GameOverViewer(new Win(20));
        GUI gui = Mockito.mock(LanternaGUI.class);
        gameOverViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(54)).drawText(any(Position.class), anyString(), anyString());
    }
}
