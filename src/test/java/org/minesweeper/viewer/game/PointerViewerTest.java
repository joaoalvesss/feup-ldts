package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Bomb;
import org.minesweeper.model.game.elements.Pointer;
import org.minesweeper.viewer.game.BombViewer;
import org.minesweeper.viewer.game.PointerViewer;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class PointerViewerTest {
    private Pointer pointer;
    private PointerViewer viewer;
    private GUI gui;

    @BeforeEach
    void helper(){
        pointer = new Pointer(10,0);
        viewer = new PointerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawPointer(){
        viewer.draw(pointer, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPointer(any(Position.class), anyString(), anyString());
    }
}
