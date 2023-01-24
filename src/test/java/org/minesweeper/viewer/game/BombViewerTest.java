package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Bomb;
import org.minesweeper.viewer.game.BombViewer;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class BombViewerTest {
    private Bomb bomb;
    private BombViewer viewer;
    private GUI gui;

    @BeforeEach
    void helper(){
      bomb = new Bomb(2,5);
      viewer = new BombViewer();
      gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawBomb(){
        viewer.draw(bomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }
}
