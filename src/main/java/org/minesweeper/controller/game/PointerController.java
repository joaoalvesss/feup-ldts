package org.minesweeper.controller.game;

import org.minesweeper.Game;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.model.game.elements.*;
import org.minesweeper.model.gameover.Loss;
import org.minesweeper.model.gameover.Win;
import org.minesweeper.states.GameOverState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PointerController extends GameController{

    private int numberCounter = 0;

    private final List<Position> checkedNums = new ArrayList<>();

    public PointerController(Board board) {
        super(board);
    }

    public void movePointerUp(){
        movePointer(getModel().getPointer().getCellPosition().goUp());
    }

    public void movePointerDown(){
        movePointer(getModel().getPointer().getCellPosition().goDown());
    }

    public void movePointerLeft(){
        movePointer(getModel().getPointer().getCellPosition().goLeft());
    }

    public void movePointerRight(){
        movePointer(getModel().getPointer().getCellPosition().goRight());
    }

    private void movePointer(Position position){
        if(getModel().canMove(position)) getModel().getPointer().setCellPosition(position);
    }

    private void placeFlag() {
        Cell cell = getModel().getCellAt(getModel().getPointer().getCellPosition());

        if(!cell.getClass().getSimpleName().equals("ClickCell")) return;

        if (((ClickCell) cell).isFlagged()) {
            ((ClickCell) cell).unflagCell();
            getModel().getCounter().increment();
            getModel().placeRemoveFlag(cell.getCellPosition(), "remove");
        }
        else {
            ((ClickCell) cell).flagCell();
            getModel().getCounter().decrement();
            getModel().placeRemoveFlag(cell.getCellPosition(), "place");
        }
    }

    private String getCellType(){
        Position pos = getModel().getPointer().getCellPosition();
        List<Bomb> bombs = getModel().getBombs();
        List<Number> numbers = getModel().getNumbers();
        List<EmptyCell> emptyCells = getModel().getEmptyCells();

        for (Bomb bomb : bombs) {
            Position bombPos = bomb.getCellPosition();
            if(bombPos.equals(pos)) return "BOMB";
        }

        for (Number number : numbers) {
            Position numPos = number.getCellPosition();
            if(numPos.equals(pos)) return "NUM";
        }

        for (EmptyCell emptyCell : emptyCells) {
            Position emptyCellPos = emptyCell.getCellPosition();
            if(emptyCellPos.equals(pos)) return "EMPTY_CELL";
        }
        return "ERR";
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time){
        int x;
        int y;

        if (action == GUI.ACTION.UP) movePointerUp();
        if (action == GUI.ACTION.RIGHT) movePointerRight();
        if (action == GUI.ACTION.DOWN) movePointerDown();
        if (action == GUI.ACTION.LEFT) movePointerLeft();
        if (action == GUI.ACTION.SELECT) {
            
            for (Cell cell : getModel().getBoard()) {
                if(cell.getCellPosition().equals(getModel().getPointer().getCellPosition())){
                    if(cell.getClass().getSimpleName().equals("ClickCell"))
                        if(((ClickCell) cell).isFlagged())
                            return;
                    if(cell.getClass().getSimpleName().equals("Number"))
                        return;
                    if(cell.getClass().getSimpleName().equals("EmptyCell"))
                        return;
                }
            }
            
            switch (getCellType()) {
                case "BOMB":
                    int gameTime = getModel().getTimer().getTime();
                    int numBombs = getModel().getBombCounter();
                    getModel().getTimer().stop();
                    game.setState(new GameOverState(new Loss(gameTime, numBombs)));
                    break;
                
                case "ERR":
                    System.out.println("Something went wrong with the pointer");
                    game.setState(null);
                    break;

                case "NUM":
                    List<Cell> board = getModel().getBoard();
                    Position pointerPos = getModel().getPointer().getCellPosition();
                    x = pointerPos.getX();
                    y = pointerPos.getY();

                    for (Cell cell : new ArrayList<>(board)) {
                        Position cellPos = cell.getCellPosition();
                        if(pointerPos.equals(cellPos)){
                            board.remove(cell);

                            List<Number> numbers = getModel().getNumbers();

                            for (Number number : new ArrayList<>(numbers)) {
                                Position numPos = number.getCellPosition();
                                if(numPos.equals(pointerPos)){
                                    Number num = new Number(x, y);
                                    num.setNum(number.getNum());
                                    board.add(num);
                                    numberCounter++;
                                    checkedNums.add(number.getCellPosition());
                                }
                            }
                        }
                    }
                    break;
                
                case "EMPTY_CELL":
                    x = getModel().getPointer().getCellPosition().getX();
                    y = getModel().getPointer().getCellPosition().getY();
                    floodFill(x,y,false);
            
                default:
                    break;
            }
        } 
        if (action == GUI.ACTION.FLAG) placeFlag();

        if (getModel().getNumbers().size() == numberCounter) {
            getModel().getTimer().stop();
            int gameTime = getModel().getTimer().getTime();
            game.setState(new GameOverState(new Win(gameTime)));
        }
    }

    private void floodFill(int x, int y, Boolean diagonal){
        List<Cell> board = getModel().getLogicBoard();
        List<Cell> changeBoard = getModel().getBoard();
        Position position = new Position(x, y);

        for (Cell cell : new ArrayList<>(board)) {
            Position cellPos = cell.getCellPosition();

            if(cellPos.equals(position)){
                for (Cell changeCell : new ArrayList<>(changeBoard)) {
                    if(position.equals(changeCell.getCellPosition())) {
                        if(changeCell.getClass().getSimpleName().equals("EmptyCell"))
                            return;
                    }  
                }

                if(cell.getClass().getSimpleName().equals("Number")){

                    for (Cell iterCell : new ArrayList<>(changeBoard)) {
                        if(iterCell.getCellPosition().equals(position)){
                            changeBoard.remove(iterCell);
                            if(iterCell.getClass().getSimpleName().equals("ClickCell")){
                                if(((ClickCell) iterCell).isFlagged())
                                    getModel().getCounter().increment();
                            }       
                        }
                    }
                    
                    Number num = new Number(x, y);

                    for (Number number : new ArrayList<>(getModel().getNumbers())) {
                        if(number.getCellPosition().equals(num.getCellPosition())){
                            num.setNum(number.getNum());
                        }
                    }
                    
                    changeBoard.add(num);
                    if (!checkedNums.contains(num.getCellPosition())) {
                        checkedNums.add(num.getCellPosition());
                        numberCounter++;
                    }
                    return;
                }

                if(diagonal) return;
                else{
                    for (Cell iterCell : new ArrayList<>(changeBoard)) {
                        if(iterCell.getCellPosition().equals(position)){
                            changeBoard.remove(iterCell);
                            if(((ClickCell) iterCell).isFlagged())
                                getModel().getCounter().increment();
                        }
                    }

                    changeBoard.add(new EmptyCell(x, y));
                    floodFill(x+1, y, false);
                    floodFill(x, y+1, false);
                    floodFill(x-1, y, false);
                    floodFill(x, y-1,false );
                    floodFill(x+1,y+1, true);
                    floodFill(x+1, y-1, true);
                    floodFill(x-1, y-1, true );
                    floodFill(x-1, y+1,true );
                    return;
                }
            }
        }   
    }
}