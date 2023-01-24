package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.elements.EmptyCell;

public class EmptyCellViewer implements CellViewer<EmptyCell> {
    @Override
    public void draw(EmptyCell cell, GUI gui){
        gui.drawText(cell.getCellPosition(), " ", "#FF00FF");
    }
}
