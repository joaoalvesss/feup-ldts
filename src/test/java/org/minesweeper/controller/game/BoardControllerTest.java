package org.minesweeper.controller.game;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.minesweeper.Game;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.GameTimer;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.states.MenuState;
import org.mockito.Mock;
import org.mockito.Mockito;

class BoardControllerTest {

    @Test
    void firstTestConstructor() {
        Board board = new Board(1, 1);
        assertSame(board, (new BoardController(board, new PointerController(board))).getModel());
    }

    @Test
    void secondTestConstructor() {
        Board board = new Board(0, 10);
        assertSame(board, (new BoardController(board, new PointerController(board))).getModel());
    }

    @Test
    void thirdTestConstructor() {
        Board board = new Board(1, 1);
        board.setWalls(new ArrayList<>());
        assertSame(board, (new BoardController(board, new PointerController(board))).getModel());
    }

    @Test
    void fourthTestConstructor() {
        Board board = new Board(0, Integer.MIN_VALUE);
        board.setNumbers(new ArrayList<>());
        assertSame(board, (new BoardController(board, new PointerController(board))).getModel());
    }

    @Test
    void stepQuitTest() {
        Game game = Mockito.mock(Game.class);
        Board board = new Board(1, 1);
        Board spy = Mockito.spy(board);
        BoardController controller = new BoardController(spy, new PointerController(spy));
        GUI.ACTION action = GUI.ACTION.QUIT;
        long time = 1;
        controller.step(game, action, time);
        Mockito.verify(game, Mockito.times(1)).setState(any(MenuState.class));
    }


    @Test
    void stepSelectTest() {
        PointerController pointerController = Mockito.mock(PointerController.class);
        Game game = Mockito.mock(Game.class);
        long time = 1;
        Board board = new Board(2, 3);
        BoardController controller = new BoardController(board, pointerController);
        GUI.ACTION action = GUI.ACTION.SELECT;
        controller.step(game, action, 1);
        Mockito.verify(pointerController, Mockito.times(1)).step(game, action, time);
    }
}

