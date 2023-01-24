package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.elements.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberViewer implements CellViewer<Number> {
    private List<String> numColours;

    public void initializeColours(){
        this.numColours = new ArrayList<>();
        numColours.add("#ADD8E6"); // 1 color - light blue
        numColours.add("#00FF00"); // 2 color - green
        numColours.add("#FF0000"); // 3 color - red
        numColours.add("#00008B"); // 4 color - dark blue
        numColours.add("#964B00"); // 5 color - brown
        numColours.add("#00FFFF"); // 6 color - aqua
        numColours.add("#FFA500"); // 7 color - orange
        numColours.add("#FFC0CB"); // 8 color - pink
    }
    @Override
    public void draw(Number cell, GUI gui){
        if (numColours == null) {
            initializeColours();
        }
        int num = cell.getNum();
        gui.drawText(cell.getCellPosition(), String.valueOf(num), numColours.get(num-1));
    }
}
