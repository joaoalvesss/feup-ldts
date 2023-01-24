package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.elements.Cell;

public interface CellViewer<T extends Cell>{
    void draw(T cell, GUI gui);
}
