package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Bomb;
import org.minesweeper.model.game.elements.ClickCell;
import org.minesweeper.viewer.game.BombViewer;
import org.minesweeper.viewer.game.ClickCellViewer;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class ClickCellViewerTest {
    private ClickCell clickCell;
    private ClickCellViewer viewer;
    private GUI gui;

    @BeforeEach
    void helper(){
        clickCell = new ClickCell(1,0);
        viewer = new ClickCellViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawClickCellUnflagged() {
        viewer.draw(clickCell, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(clickCell.getCellPosition(), "O", "white");
    }

    @Test
    public void drawClickCellFlagged() {
       clickCell.flagCell();
       viewer.draw(clickCell, gui);
       Mockito.verify(gui, Mockito.times(1)).drawText(clickCell.getCellPosition(), "`", "red");
    }
}
