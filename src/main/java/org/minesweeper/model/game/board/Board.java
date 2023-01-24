package org.minesweeper.model.game.board;

import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {

    private List<Cell> logicBoard;
    private List<Cell> board;
    private List<Bomb> bombs;
    private List<Number> numbers;
    private List<Wall> walls;
    private List<EmptyCell> emptyCells;
    private Pointer pointer;
    private final GameTimer timer;
    private FlagCounter flagCounter;
    private int bombCounter;

    public Board(int height, int width){this.timer = new GameTimer();}

    public List<Cell> getBoard(){
        return this.board;
    }
    public List<Bomb> getBombs(){ return this.bombs;}
    public int getBombCounter() { return this.bombCounter; }
    public Pointer getPointer() {return pointer;}
    public GameTimer getTimer() { return this.timer; }
    public FlagCounter getCounter() { return this.flagCounter; }
    public List<Wall> getWalls() { return walls; }
    public List<Number> getNumbers() {return numbers;}
    public List<EmptyCell> getEmptyCells() {
        return this.emptyCells;
    }
    public List<Cell> getLogicBoard(){
        return logicBoard;
    }
    public Cell getCellAt(Position position) {
        for (Cell cell: board)
            if (cell.getCellPosition().equals(position))
                return cell;
        return null;
    }

    public void setPointer(Pointer pointer) {this.pointer = pointer;}
    public void setBoard(List<Cell> newBoard){this.board = newBoard;}
    public void setWalls(List<Wall> walls){ this.walls = walls;}
    public void setNumbers(List<Number> numbers){this.numbers = numbers;}
    public void setEmptyCells(List<EmptyCell> emptyCells) {this.emptyCells = emptyCells;}
    public void setLogicBoard(){
        logicBoard = new ArrayList<>();
        logicBoard.addAll(bombs);
        logicBoard.addAll(numbers);
        logicBoard.addAll(emptyCells);
    }
    public void setBombs(List<Bomb> bombs){
        this.bombs = bombs;
        this.flagCounter = new FlagCounter(bombs.size());
        this.bombCounter = bombs.size();
    }

    public boolean canMove(Position position){
        for(Wall wall: walls){
            if(Objects.equals(wall.getLocation(), "side")){
                Position p1 = new Position(wall.getCellPosition().getX()-1,wall.getCellPosition().getY());
                Position p2 = new Position(wall.getCellPosition().getX()+1,wall.getCellPosition().getY());
                if((p1.equals(position)) || (p2.equals(position))) return false;
            }
            else {
                if (wall.getCellPosition().equals(position))
                    return false;
            }
        }
        return true;
    }

    public void placeRemoveFlag(Position position, String choice){
        for (Bomb bomb: bombs)
            if (position.equals(bomb.getCellPosition()))
                if(choice.equals("place"))
                    bombCounter--;
                else if(choice.equals("remove"))
                    bombCounter++;
    }
}
