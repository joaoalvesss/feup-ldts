package org.minesweeper.model.game.elements;

import org.minesweeper.model.Position;

public class Cell {
    private Position cellPosition;

    public Cell(int x, int y){
        this.cellPosition = new Position(x, y);
    }

    public Position getCellPosition() {
        return this.cellPosition;
    }

    public void setCellPosition(Position cellPosition) {
        this.cellPosition = cellPosition;
    }

    public void shiftCell(Position shiftAmount){
        this.cellPosition.addPosition(shiftAmount);
    }

}
