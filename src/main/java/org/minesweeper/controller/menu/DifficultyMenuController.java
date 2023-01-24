package org.minesweeper.controller.menu;

import org.minesweeper.Game;
import org.minesweeper.controller.Controller;
import org.minesweeper.gui.GUI.ACTION;
import org.minesweeper.model.menu.DifficultyMenu;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.states.MenuState;

public class DifficultyMenuController extends Controller<DifficultyMenu>{

    public DifficultyMenuController(DifficultyMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, ACTION action, long time){
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedEasy())
                    game.setDifficulty("easy");
                else if (getModel().isSelectedMedium())
                    game.setDifficulty("medium");
                else
                    game.setDifficulty("hard");
                game.setState(new MenuState(new MainMenu()));
            }
        }
    }
}
