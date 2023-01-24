package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.FlagCounter;
import org.minesweeper.viewer.Viewer;

public class CounterViewer extends Viewer<FlagCounter> {
    private final Position position;

    public CounterViewer(FlagCounter counter) {
        super(counter);
        this.position = new Position(10, 4);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(this.position, String.format("%03d", getModel().getCounter()), "#FFFFFF");
    }
}
