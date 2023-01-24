package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.elements.Pointer;

public class PointerViewer implements CellViewer<Pointer> {
    @Override
    public void draw(Pointer cell, GUI gui) {
        gui.drawPointer(cell.getCellPosition(), "O", "#33FFE6");
    }
}
