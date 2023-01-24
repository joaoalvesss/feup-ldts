package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Wall;

public class WallViewer implements CellViewer<Wall>{
    @Override
    public void draw(Wall cell, GUI gui){
        Position position = cell.getCellPosition();
        switch (cell.getLocation()) {
            case "Edge" -> gui.drawText(position, "+", "#008B8B");
            case "topBottom" -> gui.drawText(position, "-", "#008B8B");
            case "side" -> gui.drawText(position, "|", "#008B8B");
        }
    }
}
