package org.minesweeper.viewer.menu;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.menu.DifficultyMenu;
import org.minesweeper.model.menu.MenuBox;
import org.minesweeper.viewer.Viewer;

public class DifficultyMenuViewer extends Viewer<DifficultyMenu>{

    public DifficultyMenuViewer(DifficultyMenu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        MenuBoxViewer menuBoxViewer = new MenuBoxViewer(
                new MenuBox(new Position(7, 5), 15, 22));
        menuBoxViewer.drawElements(gui);
        gui.drawText(new Position(17, 7), "Menu", "#FFFFFF");

        for(int i=7; i<27; i++){
            gui.drawText(new Position(i+2,9), "-", "#FFFFFF");
        }
        
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(10, 11+i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#008B8B" : "#FFFFFF");
        }
        
    }

}
