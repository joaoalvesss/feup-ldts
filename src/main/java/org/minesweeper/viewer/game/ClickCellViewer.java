package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.elements.ClickCell;

public class ClickCellViewer implements CellViewer<ClickCell>{

    @Override
    public void draw(ClickCell cell, GUI gui) {
        String cellChar = cell.isFlagged() ? "`" : "O";
        String cellColor = cell.isFlagged() ? "red" : "white";
        gui.drawText(cell.getCellPosition(), cellChar, cellColor);
    }
}
