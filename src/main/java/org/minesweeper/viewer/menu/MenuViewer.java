package org.minesweeper.viewer.menu;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.model.menu.MenuBox;
import org.minesweeper.viewer.Viewer;


public class MenuViewer extends Viewer<MainMenu> {

    public MenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(GUI gui) {
        MenuBoxViewer menuBoxViewer = new MenuBoxViewer(
                new MenuBox(new Position(7, 5), 15, 22));
        menuBoxViewer.drawElements(gui);
        gui.drawText(new Position(13, 7), "Minesweeper", "#FFFFFF");

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

