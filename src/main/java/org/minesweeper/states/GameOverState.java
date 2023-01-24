package org.minesweeper.states;

import org.minesweeper.controller.Controller;
import org.minesweeper.controller.gameover.GameOverController;
import org.minesweeper.model.gameover.GameOver;
import org.minesweeper.viewer.Viewer;
import org.minesweeper.viewer.gameover.GameOverViewer;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver gameOver) { super(gameOver); }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(new GameOver(getModel().getTime(), getModel().getMessage()));
    }
}
