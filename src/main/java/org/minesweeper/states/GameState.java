package org.minesweeper.states;

import org.minesweeper.controller.Controller;
import org.minesweeper.controller.game.BoardController;
import org.minesweeper.controller.game.PointerController;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.Pointer;
import org.minesweeper.viewer.Viewer;
import org.minesweeper.viewer.game.GameViewer;

public class GameState extends State<Board>{
    public GameState(Board board){ super(board); }

    @Override
    protected Viewer<Board> getViewer(){
        return new GameViewer(getModel());
    }
    
    @Override
    protected Controller<Board> getController(){
        return new BoardController(getModel(), new PointerController(getModel()));
    }

}
