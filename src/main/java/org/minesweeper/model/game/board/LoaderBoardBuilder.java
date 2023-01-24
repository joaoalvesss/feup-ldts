package org.minesweeper.model.game.board;

import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class LoaderBoardBuilder extends BoardBuilder {
    private final String difficulty;
    private final Position shiftAmount;
    private int width;
    private int height;
    private List<Bomb> bombs;
    private List<Number> numbers;
    private List<ClickCell> clickCells;

    public LoaderBoardBuilder(String difficulty) {
        this.difficulty = difficulty;

        Position hardPosition = new Position(4, 7);
        Position mediumPosition = new Position(11, 7);
        Position easyPosition = new Position(14, 11);
        switch (difficulty) {
            case "easy" -> this.shiftAmount = easyPosition;
            case "medium" -> this.shiftAmount = mediumPosition;
            case "hard" -> this.shiftAmount = hardPosition;
            default -> this.shiftAmount = new Position(0, 0);
        }
    }

    private Boolean bombInList(Bomb inBomb, List<Bomb> bombs){
        Position inPos = inBomb.getCellPosition();
        for (Bomb bomb : bombs) 
            if(bomb.getCellPosition().equals(inPos))
                return true;
        return false;
    }

    protected List<Bomb> createBombs() {
        bombs = new ArrayList<>();
        List<Bomb> returnBombs = new ArrayList<>();
        Random rand = new Random();
        int n;

        if (difficulty.equals("easy")) { this.width = 10; this.height = 10; n = 10; }
        else if (difficulty.equals("medium")) { this.width = 16; this.height = 16; n = 40; }
        else { this.width = 30; this.height = 16; n = 99; }

        for (int i = 0; i < n; i++) {
            int rand_x = rand.nextInt(this.width);
            int rand_y = rand.nextInt(this.height);
            Bomb tempBomb = new Bomb(rand_x, rand_y);
            if (!bombInList(tempBomb, bombs))
                bombs.add(tempBomb);
            else
                i--;
        }

        for (Bomb bomb : bombs) {
            Bomb tempBomb = new Bomb(bomb.getCellPosition().getX(), bomb.getCellPosition().getY());
            returnBombs.add(tempBomb);
        }
        for (Bomb bomb : returnBombs) bomb.shiftCell(shiftAmount);
        return returnBombs;
    }

    protected int getWidth() {
        return switch (difficulty) {
            case "easy" -> 10;
            case "medium" -> 16;
            case "hard" -> 30;
            default -> -1;
        };
    }

    protected int getHeight() {
        return switch (difficulty) {
            case "easy" -> 10;
            case "medium", "hard" -> 16;
            default -> -1;
        };
    }

    @Override
    protected List<ClickCell> createClickableCells() {
        clickCells = new ArrayList<>();

        for(int i = 0; i < getWidth(); i++){
            for(int j = 0; j < getHeight(); j++){
                ClickCell tempCell = new ClickCell(i, j);
                tempCell.shiftCell(shiftAmount);
                clickCells.add(tempCell);
            }
        }
        return clickCells;
    }

    @Override
    protected Pointer createPointer() {
        Pointer tempPointer = new Pointer(getWidth()/2, getHeight()/2);
        tempPointer.shiftCell(shiftAmount);
        return tempPointer;
    }

    @Override
    protected List<Wall> createWalls(){
        List<ClickCell> cells = createClickableCells();
        List<Wall> walls = new ArrayList<>();
        int xmin = cells.get(0).getCellPosition().getX();
        int xmax = cells.get(cells.size()-1).getCellPosition().getX();
        int ymin = cells.get(0).getCellPosition().getY();
        int ymax = cells.get(cells.size()-1).getCellPosition().getY();

        walls.add(new Wall(xmin-2, ymin-1, "Edge"));
        walls.add(new Wall(xmin-2, ymax+1, "Edge"));
        walls.add(new Wall(xmax+2, ymin-1, "Edge"));
        walls.add(new Wall(xmax+2, ymax+1, "Edge"));

        for(int i = 0; i < getHeight(); i++){
            walls.add(new Wall(xmin-2, ymin+i, "side"));
            walls.add(new Wall(xmax+2, ymin+i, "side"));
        }

        for(int j = 0; j < getWidth()+2; j++){
            walls.add(new Wall(xmin+j-1, ymin-1, "topBottom"));
            walls.add(new Wall(xmin+j-1, ymax+1, "topBottom"));
        }
        return walls;
    }

    private Boolean checkAdjacentCell(Cell cell){
        int x = cell.getCellPosition().getX();
        int y = cell.getCellPosition().getY();

        if(x < 0 || x > this.width-1) return false;
        return y >= 0 && y <= this.height - 1;
    }

    private Boolean checkBomb(Cell cell){
        Position cellPos = cell.getCellPosition();

        for (Bomb bomb : bombs) {
            Position bombPosition = bomb.getCellPosition();
            if(cellPos.equals(bombPosition))
                return true;
        }
        return false;
    }

    private int numberInList(List<Number> numbers, Number inNumber){
        Position inPos = inNumber.getCellPosition();
        int i = 0;

        for (Number number : numbers) {
            if(number.getCellPosition().equals(inPos))
                return i;
            i++;
        }
        return -1;
    }

    @Override
    protected List<Number> createNumbers(){
        numbers = new ArrayList<>();
        List<Number> returnNumbers = new ArrayList<>();

        for (Bomb bomb : bombs) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++){
                    Number tempNumber = new Number(bomb.getCellPosition().getX()+i,bomb.getCellPosition().getY()+j);
                    int numberPosition = numberInList(numbers, tempNumber);

                    if(checkBomb(tempNumber)) continue;

                    if(numberPosition == -1){
                        if(checkAdjacentCell(tempNumber))
                            numbers.add(tempNumber);
                    }
                    else numbers.get(numberPosition).incrementNumber();
                }
            }
        }

        for (Number number : numbers) {
            Number tempNumber = new Number(number.getCellPosition().getX(),number.getCellPosition().getY());
            tempNumber.setNum(number.getNum());
            returnNumbers.add(tempNumber);
        }

        for (Number number : returnNumbers) { number.shiftCell(shiftAmount); }

        return returnNumbers;
    }

    @Override
    protected List<EmptyCell> createEmptyCells(){
        List<EmptyCell> emptyCells = new ArrayList<>();
        List<EmptyCell> returnEmptyCell = new ArrayList<>();

        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                EmptyCell tempCell = new EmptyCell(i, j);
                emptyCells.add(tempCell);
            }
        }

        for (EmptyCell emptyCell : new ArrayList<>(emptyCells)) {
            for (Bomb bomb : bombs) {
                Position bombPos = bomb.getCellPosition();
                Position emptyCellPos = emptyCell.getCellPosition();
                if(bombPos.equals(emptyCellPos))
                    emptyCells.remove(emptyCell);
            }

            for (Number number: numbers) {
                Position numberPos = number.getCellPosition();
                Position emptyCellPos = emptyCell.getCellPosition();
                if(numberPos.equals(emptyCellPos))
                    emptyCells.remove(emptyCell);
            }
        }

        for (EmptyCell emptyCell : emptyCells) {
            EmptyCell tempEmptyCell = new EmptyCell(emptyCell.getCellPosition().getX(), emptyCell.getCellPosition().getY());
            returnEmptyCell.add(tempEmptyCell);
        }

        for (EmptyCell emptyCell : returnEmptyCell) emptyCell.shiftCell(shiftAmount);

        return returnEmptyCell;
    }

    @Override
    protected List<Cell> createVisibleBoard(){
        List<Cell> board = new ArrayList<>();

        for (ClickCell clickCell : clickCells)
            board.add(new ClickCell(clickCell.getCellPosition().getX(), clickCell.getCellPosition().getY()));

        return board;
    }
}
