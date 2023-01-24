package org.minesweeper.controller.game;

import org.minesweeper.controller.Controller;
import org.minesweeper.model.game.board.Board;

public abstract class GameController extends Controller<Board> {

    public GameController(Board board) {
        super(board);
    }
}
