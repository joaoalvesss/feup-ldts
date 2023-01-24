package org.minesweeper.model.game.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Bomb;
import org.minesweeper.model.game.elements.Cell;
import org.minesweeper.model.game.elements.EmptyCell;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.model.game.elements.Pointer;
import org.minesweeper.model.game.elements.Wall;
import org.mockito.Mockito;

class BoardTest {

    @Test
    void testConstructor1() {
        Board actualBoard = new Board(1, 1);
        ArrayList<Cell> cellList = new ArrayList<>();
        actualBoard.setBoard(cellList);
        ArrayList<EmptyCell> emptyCellList = new ArrayList<>();
        actualBoard.setEmptyCells(emptyCellList);
        ArrayList<Number> numberList = new ArrayList<>();
        actualBoard.setNumbers(numberList);
        Pointer pointer = new Pointer(2, 3);

        actualBoard.setPointer(pointer);
        ArrayList<Wall> wallList = new ArrayList<>();
        actualBoard.setWalls(wallList);
        List<Cell> board = actualBoard.getBoard();
        assertSame(cellList, board);
        assertEquals(emptyCellList, board);
        assertEquals(numberList, board);
        assertEquals(wallList, board);
        assertEquals(0, actualBoard.getBombCounter());
        assertNull(actualBoard.getBombs());
        assertNull(actualBoard.getCounter());
        List<EmptyCell> emptyCells = actualBoard.getEmptyCells();
        assertSame(emptyCellList, emptyCells);
        assertEquals(board, emptyCells);
        List<Number> numbers = actualBoard.getNumbers();
        assertEquals(numbers, emptyCells);
        List<Wall> walls = actualBoard.getWalls();
        assertEquals(walls, emptyCells);
        assertNull(actualBoard.getLogicBoard());
        assertSame(numberList, numbers);
        assertEquals(emptyCellList, numbers);
        assertEquals(board, numbers);
        assertEquals(walls, numbers);
        assertSame(pointer, actualBoard.getPointer());
        assertSame(wallList, walls);
        assertEquals(emptyCellList, walls);
        assertEquals(numberList, walls);
        assertEquals(board, walls);
    }

    @Test
    void testConstructor2() {
        assertEquals(0, (new Board(1, 1)).getTimer().getTime());
    }

    @Test
    void testGetCellAt1() {
        Board board = new Board(1, 1);
        board.setBoard(new ArrayList<>());
        assertNull(board.getCellAt(new Position(1, 1)));
    }

    @Test
    void testGetCellAt2() {
        ArrayList<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(2, 3));

        Board board = new Board(1, 1);
        board.setBoard(cellList);
        assertNull(board.getCellAt(new Position(1, 1)));
    }

    @Test
    void testGetCellAt3() {
        ArrayList<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(1, 3));

        Board board = new Board(1, 1);
        board.setBoard(cellList);
        assertNull(board.getCellAt(new Position(1, 1)));
    }

    @Test
    void testGetCellAt4() {
        ArrayList<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(2, 3));

        Board board = new Board(1, 1);
        board.setBoard(cellList);
        assertNull(board.getCellAt(null));
    }

    @Test
    void testGetCellAt5() {
        ArrayList<Cell> cellList = new ArrayList<>();
        Cell cell = new Cell(1, 1);

        cellList.add(cell);

        Board board = new Board(1, 1);
        board.setBoard(cellList);
        assertSame(cell, board.getCellAt(new Position(1, 1)));
    }

    @Test
    void testGetCellAt6() {
        Cell cell = new Cell(1, 3);
        cell.setCellPosition(new Position(1, 1));

        ArrayList<Cell> cellList = new ArrayList<>();
        cellList.add(cell);

        Board board = new Board(1, 1);
        board.setBoard(cellList);
        assertSame(cell, board.getCellAt(new Position(1, 1)));
    }

    @Test
    void testGetCellAt7() {
        Board board = new Board(1, 1);
        board.setBoard(new ArrayList<>());
        assertNull(board.getCellAt(new Position(1, 1)));
    }

    @Test
    void testGetCellAt8() {
        ArrayList<Cell> cellList = new ArrayList<>();
        cellList.add(new Cell(1, 3));

        Board board = new Board(1, 1);
        board.setBoard(cellList);
        assertNull(board.getCellAt(new Position(1, 1)));
        assertEquals(0, board.getTimer().getTime());
    }

    @Test
    void testSetBombs1() {
        Board board = new Board(1, 1);
        ArrayList<Bomb> bombList = new ArrayList<>();
        board.setBombs(bombList);
        assertEquals(0, board.getBombCounter());
        assertSame(bombList, board.getBombs());
        assertEquals(0, board.getCounter().getCounter());
    }

    @Test
    void testSetBombs2() {
        Board board = new Board(1, 1);
        board.setBoard(new ArrayList<>());
        board.setNumbers(new ArrayList<>());
        ArrayList<Bomb> bombList = new ArrayList<>();
        board.setBombs(bombList);
        assertEquals(0, board.getBombCounter());
        assertSame(bombList, board.getBombs());
        assertEquals(0, board.getCounter().getCounter());
    }

    @Test
    void testCanMove1() {
        Board board = new Board(1, 1);
        board.setWalls(new ArrayList<>());
        assertTrue(board.canMove(new Position(1, 1)));
    }

    @Test
    void testCanMove2() {
        ArrayList<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall(2, 3, "side"));

        Board board = new Board(1, 1);
        board.setWalls(wallList);
        assertTrue(board.canMove(new Position(1, 1)));
    }

    @Test
    void testCanMove3() {
        ArrayList<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall(2, 3, "side"));
        wallList.add(new Wall(3, 3, "side"));

        Board board = new Board(1, 1);
        board.setWalls(wallList);
        assertTrue(board.canMove(new Position(1, 1)));
    }

    @Test
    void testCanMove4() {
        ArrayList<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall(2, 1, "side"));
        wallList.add(new Wall(2, 3, "Edge"));

        Board board = new Board(1, 1);
        board.setWalls(wallList);
        assertFalse(board.canMove(new Position(1, 1)));
    }

    @Test
    void testCanMove5() {
        ArrayList<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall(2, 3, "topBottom"));

        Board board = new Board(1, 1);
        board.setWalls(wallList);
        assertTrue(board.canMove(null));
    }

    @Test
    void testCanMove6() {
        ArrayList<Wall> wallList = new ArrayList<>();
        wallList.add(new Wall(0, 1, "side"));
        wallList.add(new Wall(2, 3, "side"));

        Board board = new Board(1, 1);
        board.setWalls(wallList);
        assertFalse(board.canMove(new Position(1, 1)));
    }

    @Test
    void testCanMove7() {
        Wall wall = new Wall(2, 3, "side");
        wall.setCellPosition(new Position(1, 1));

        ArrayList<Wall> wallList = new ArrayList<>();
        wallList.add(wall);

        Board board = new Board(1, 1);
        board.setWalls(wallList);
        assertTrue(board.canMove(new Position(1, 1)));
    }

    @Test
    void testSetLogicBoard() {
        Board board = new Board(3, 3);
        List<Bomb> bombs = Arrays.asList(new Bomb(1, 1));
        List<Number> numbers = Arrays.asList(new Number(2, 2));
        List<EmptyCell> emptyCells = Arrays.asList(new EmptyCell(3, 3));
        board.setBombs(bombs);
        board.setNumbers(numbers);
        board.setEmptyCells(emptyCells);
        board.setLogicBoard();
        int bombCounter = 0, numberCounter = 0, emptyCellCounter = 0;
        for (Cell cell: board.getLogicBoard()) {
            if (cell.getClass() == Bomb.class)
                bombCounter++;
            else if (cell.getClass() == Number.class)
                numberCounter++;
            else if (cell.getClass() == EmptyCell.class)
                emptyCellCounter++;
        }
        assertEquals(1, bombCounter);
        assertEquals(1, numberCounter);
        assertEquals(1, emptyCellCounter);
    }

    @Test
    void testPlaceFlag() {
        Board board = new Board(1, 1);
        List<Bomb> bombs = Arrays.asList(new Bomb(1, 1));
        board.setBombs(bombs);
        board.placeRemoveFlag(new Position(1, 1), "place");
        assertEquals(0, board.getBombCounter());
    }

    @Test
    void testRemoveFlag() {
        Board board = new Board(1, 1);
        List<Bomb> bombs = Arrays.asList(new Bomb(1, 1));
        board.setBombs(bombs);
        board.placeRemoveFlag(new Position(1, 1), "remove");
        assertEquals(2, board.getBombCounter());
    }
}

