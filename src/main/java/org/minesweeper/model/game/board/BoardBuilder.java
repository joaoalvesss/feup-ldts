package org.minesweeper.model.game.board;

import org.minesweeper.model.game.elements.Number;
import org.minesweeper.model.game.elements.*;

import java.util.List;

public abstract class BoardBuilder {
    public Board createBoard(){
        Board board = new Board(getWidth(), getHeight());
        board.setBombs(createBombs());
        board.setNumbers(createNumbers());
        board.setPointer(createPointer());
        board.setWalls(createWalls());
        board.setEmptyCells(createEmptyCells());
        board.setBoard(createVisibleBoard());
        board.setLogicBoard();
        return board;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();

    protected abstract List<Bomb> createBombs();
    protected abstract List<ClickCell> createClickableCells();
    protected abstract Pointer createPointer();
    protected abstract List<Wall> createWalls();
    protected abstract List<Number> createNumbers();
    protected abstract List<EmptyCell> createEmptyCells();
    protected abstract List<Cell> createVisibleBoard();
}
