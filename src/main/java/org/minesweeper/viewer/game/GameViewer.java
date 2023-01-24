package org.minesweeper.viewer.game;

import org.minesweeper.gui.GUI;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.model.game.elements.*;
import org.minesweeper.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Board> {
    public GameViewer(Board board) {
        super(board);
    }

    @Override
    public void drawElements(GUI gui) {
        drawBoard(gui, getModel().getBoard());
        drawCells(gui, getModel().getWalls(), new WallViewer());
        drawTimer(gui, new TimerViewer(getModel().getTimer()));
        drawCounter(gui, new CounterViewer(getModel().getCounter()));
        drawCell(gui, getModel().getPointer(), new PointerViewer());
    }

    private void drawBoard(GUI gui, List<Cell> board){
        for (Cell cell : board) {
            int x = cell.getCellPosition().getX();
            int y = cell.getCellPosition().getY();

            switch (cell.getClass().getSimpleName()) {
                case "ClickCell":
                    ClickCell clickCell = new ClickCell(x,y);
                    if(((ClickCell) cell).isFlagged()) clickCell.flagCell();
                    drawCell(gui, clickCell, new ClickCellViewer());
                    break;

                case "Bomb":
                    Bomb bomb = new Bomb(x,y);
                    drawCell(gui, bomb, new BombViewer());
                    break;

                case "Number":
                    Number number = new Number(x,y);
                    number.setNum(((Number) cell).getNum());

                    drawCell(gui, number, new NumberViewer());
                    break;

                case "EmptyCell":
                    EmptyCell emptyCell = new EmptyCell(x,y);
                    drawCell(gui, emptyCell, new EmptyCellViewer());
                    break;
            
                default:
                    System.out.println("Something went wrong with the viewer");
                    break;
            }
        }
    }

    private <T extends Cell> void drawCells(GUI gui, List<T> cells, CellViewer<T> viewer){
        for(T cell : cells){       
            drawCell(gui,cell,viewer);
        }
    }

    private <T extends Cell> void drawCell(GUI gui, T cell, CellViewer<T> viewer) {
        viewer.draw(cell, gui);
    }

    private void drawTimer(GUI gui, TimerViewer viewer) {
        viewer.drawElements(gui);
    }

    private void drawCounter(GUI gui, CounterViewer counterViewer) {
        counterViewer.drawElements(gui);
    }
}
