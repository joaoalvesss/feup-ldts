package org.minesweeper.controller.gameover;

import org.minesweeper.Game;
import org.minesweeper.controller.Controller;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.gameover.GameOver;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.states.MenuState;

public class GameOverController extends Controller<GameOver> {

    public GameOverController(GameOver gameOver) { super(gameOver); }

    @Override
    public void step(Game game, GUI.ACTION action, long time){
        switch (action) {
            case SELECT -> game.setState(new MenuState(new MainMenu()));
            case QUIT -> game.setState(null);
        }
    }
}
