package org.minesweeper.controller.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.Pointer;
import org.minesweeper.model.game.elements.Wall;

import java.util.Arrays;

class PointerControllerTest {
    private PointerController pointerController;
    private Pointer pointer;


    @BeforeEach
    public void helper() {
        Board board = new Board(10, 10);
        pointer = new Pointer(3, 3);
        pointerController = new PointerController(board);
        board.setPointer(pointer);
        board.setWalls(Arrays.asList(new Wall(2, 3, "side"), new Wall(2, 4, "side"), new Wall(2, 2, "side")));
    }

    @Test
    void testConstructor() {
        Board board = new Board(1, 1);

        Board model = (new PointerController(board)).getModel();
        assertSame(board, model);
        assertNull(model.getBoard());
        assertNull(model.getWalls());
        assertNull(model.getPointer());
        assertEquals(0, model.getBombCounter());
        assertNull(model.getNumbers());
        assertNull(model.getLogicBoard());
        assertNull(model.getEmptyCells());
        assertNull(model.getCounter());
        assertNull(model.getBombs());
    }

    @Test
    void testMovePointerUp1() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = new Board(1, 1);
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerUp();
        verify(pointer).getCellPosition();
        verify(pointer).setCellPosition(any());
    }

    @Test
    void testMovePointerUp2() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(true);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerUp();
        verify(board).canMove(any());
        verify(board, atLeast(1)).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    @Test
    void testMovePointerUp3() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(false);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerUp();
        verify(board).canMove(any());
        verify(board).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    @Test
    void testMovePointerDown1() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = new Board(1, 1);
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerDown();
        verify(pointer).getCellPosition();
        verify(pointer).setCellPosition(any());
    }

    @Test
    void testMovePointerDown2() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(true);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerDown();
        verify(board).canMove(any());
        verify(board, atLeast(1)).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }


    @Test
    void testMovePointerDown3() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(false);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerDown();
        verify(board).canMove(any());
        verify(board).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    @Test
    void testMovePointerLeft1() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = new Board(1, 1);
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerLeft();
        verify(pointer).getCellPosition();
        verify(pointer).setCellPosition(any());
    }

    @Test
    void testMovePointerLeft2() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(true);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerLeft();
        verify(board).canMove(any());
        verify(board, atLeast(1)).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    @Test
    void testMovePointerLeft3() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(false);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerLeft();
        verify(board).canMove(any());
        verify(board).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    @Test
    void testMovePointerRight1() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = new Board(1, 1);
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerRight();
        verify(pointer).getCellPosition();
        verify(pointer).setCellPosition(any());
    }

    @Test
    void testMovePointerRight2() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(true);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerRight();
        verify(board).canMove((Position) any());
        verify(board, atLeast(1)).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    @Test
    void testMovePointerRight3() {
        Pointer pointer = mock(Pointer.class);
        doNothing().when(pointer).setCellPosition(any());
        when(pointer.getCellPosition()).thenReturn(new Position(1, 1));
        Board board = mock(Board.class);
        when(board.canMove(any())).thenReturn(false);
        when(board.getPointer()).thenReturn(new Pointer(2, 3));
        doNothing().when(board).setPointer(any());
        doNothing().when(board).setWalls(any());
        board.setWalls(new ArrayList<>());
        board.setPointer(pointer);
        (new PointerController(board)).movePointerRight();
        verify(board).canMove(any());
        verify(board).getPointer();
        verify(board).setPointer(any());
        verify(board).setWalls(any());
    }

    /*
    @Test
    public void movePointerWrongly(){
        pointerController.movePointerLeft();
        assertEquals(new Position(3,3), pointer.getCellPosition());
    }
    */
    @Test
    public void movePointerCorrectly() {
        pointerController.movePointerRight();
        pointerController.movePointerRight();
        pointerController.movePointerLeft();
        pointerController.movePointerUp();
        pointerController.movePointerDown();
        pointerController.movePointerDown();
        pointerController.movePointerDown();
        assertEquals(new Position(4, 5), pointer.getCellPosition());
    }
}

