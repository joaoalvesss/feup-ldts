package org.minesweeper.controller.game;

import org.minesweeper.Game;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.states.MenuState;

public class BoardController extends GameController{
    private final PointerController pointerController;

    public BoardController(Board board, PointerController pointerController) {
        super(board);
        this.pointerController = pointerController;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time){
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState(new MainMenu()));
            getModel().getTimer().stop();
        }
        else
            pointerController.step(game, action, time);
    }
}
