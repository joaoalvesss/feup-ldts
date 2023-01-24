package org.minesweeper.controller.menu;

import org.minesweeper.Game;
import org.minesweeper.controller.Controller;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.board.LoaderBoardBuilder;
import org.minesweeper.model.menu.DifficultyMenu;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.states.DifficultyMenuState;
import org.minesweeper.states.GameState;

public class MenuController extends Controller<MainMenu> {
    public MenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time){
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedQuit()) game.setState(null);
                if (getModel().isSelectedDifficulty()) game.setState(new DifficultyMenuState(new DifficultyMenu()));
                if (getModel().isSelectedNewGame()) game.setState(new GameState(new LoaderBoardBuilder(game.getDifficulty()).createBoard()));
            }
        }
    }
}
