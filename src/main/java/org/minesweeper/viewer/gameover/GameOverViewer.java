package org.minesweeper.viewer.gameover;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.gameover.GameOver;
import org.minesweeper.model.gameover.Loss;
import org.minesweeper.model.menu.MenuBox;
import org.minesweeper.viewer.Viewer;
import org.minesweeper.viewer.menu.MenuBoxViewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }
    @Override
    protected void drawElements(GUI gui) {
        // draw box
        MenuBoxViewer menuBoxViewer = new MenuBoxViewer(new MenuBox(new Position(7, 5), 5, 22));
        menuBoxViewer.drawElements(gui);
        // draw message from the gameover
        gui.drawText(new Position(14, 7), getModel().getMessage(), "#FFFFFF");
        gui.drawText(new Position(13, 11),
                "Your time: " + String.format("%d" ,getModel().getTime()),
                "#FFFFFF");
        if (getModel().getClass() == Loss.class) {
            gui.drawText(new Position(5, 12), "You still had", "#FFFFFF");
            gui.drawText(new Position(19, 12), String.format("%02d", getModel().getNumBombs()), "red");
            gui.drawText(new Position(22, 12), "bombs to go", "#FFFFFF");
        }
        gui.drawText(new Position(3, 22), "Press Enter to return to the Menu", "#FFFFFF");
        gui.drawText(new Position(7, 23), "Press q to quit the game", "#FFFFFF");
    }
}
