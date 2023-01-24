package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.EmptyCell;
import org.minesweeper.viewer.game.EmptyCellViewer;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class EmptyCellViewerTest {
    private EmptyCell emptyCell;
    private EmptyCellViewer viewer;
    private GUI gui;

    @BeforeEach
    void helper(){
        emptyCell = new EmptyCell(7,9);
        viewer = new EmptyCellViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawEmptyCell(){
        viewer.draw(emptyCell, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }
}
