package org.minesweeper.viewer.menu;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.menu.MenuBox;
import org.minesweeper.viewer.Viewer;

public class MenuBoxViewer extends Viewer<MenuBox> {

    public MenuBoxViewer(MenuBox model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        Position start = getModel().start();
        int width = getModel().width();
        int height = getModel().height();
        for (int i = 1; i < width - 1; i++) {
            gui.drawText(new Position(start.getX() + 1, start.getY() + i),
                    "|", "#FFFFFF");
            gui.drawText(new Position(start.getX() + height, start.getY() + i),
                    "|", "#FFFFFF");
        }
        for (int i = 1; i < height+1; i++) {
            gui.drawText(new Position(start.getX() + i, start.getY()),
                    "-", "#FFFFFF");
            gui.drawText(new Position(start.getX() + i, start.getY() + width - 1),
                    "-", "#FFFFFF");
        }
    }
}
