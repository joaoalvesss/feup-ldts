package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.elements.Bomb;

public class BombViewer implements CellViewer<Bomb> {
    @Override
    public void draw(Bomb cell, GUI gui){
        gui.drawText(cell.getCellPosition(), "*", "#D3D3D3");
    }
}
