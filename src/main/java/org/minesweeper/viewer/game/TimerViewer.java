package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.GameTimer;
import org.minesweeper.viewer.Viewer;

public class TimerViewer extends Viewer<GameTimer> {
    private final Position position;

    public TimerViewer(GameTimer timer) {
        super(timer);
        this.position = new Position(25, 4);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(this.position, String.format("%03d", getModel().getTime()), "white");
    }
}
