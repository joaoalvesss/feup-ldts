package org.minesweeper.states;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.Pointer;

class GameStateTest {
    @Test
    void testConstructor() {
        Board board = new Board(1, 1);

        assertSame(board, (new GameState(board)).getModel());
    }

    @Test
    void testConstructor2() {
        Board board = new Board(0, 1);

        assertSame(board, (new GameState(board)).getModel());
    }

    @Test
    void testConstructor3() {
        Board board = new Board(1, 0);
        board.setBoard(new ArrayList<>());
        Board model = (new GameState(board)).getModel();
        assertSame(board, model);
    }

    @Test
    void testGetViewer() {
        Board board = new Board(1, 1);
        assertSame(board, (new GameState(board)).getViewer().getModel());
    }


    @Test
    void testGetViewer2() {
        Board board = new Board(1, 1);
        board.setPointer(new Pointer(2, -1));
        assertSame(board, (new GameState(board)).getViewer().getModel());
    }

    @Test
    void testGetController() {
        Board board = new Board(1, 1);
        assertSame(board, (new GameState(board)).getController().getModel());
    }

    @Test
    void testGetController2() {
        Board board = new Board(1, 1);
        board.setPointer(new Pointer(2, 3));
        board.setBoard(new ArrayList<>());
        assertSame(board, (new GameState(board)).getController().getModel());
    }
}

