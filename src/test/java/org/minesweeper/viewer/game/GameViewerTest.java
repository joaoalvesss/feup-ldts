package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.board.Board;
import org.minesweeper.model.game.elements.*;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.viewer.game.GameViewer;
import org.minesweeper.viewer.game.TimerViewer;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class GameViewerTest {
    private GUI gui;
    private GameViewer gameViewer;
    private Board board;

/*
    @BeforeEach
    void helper(){
        board = new Board(3,3);
        gameViewer = new GameViewer(board);
        gui = Mockito.mock(GUI.class);
        board.setClickableCells(Arrays.asList(new ClickCell(0,0), new ClickCell(1,0), new ClickCell(0,1), new ClickCell(1,1),
                                                new ClickCell(2,1), new ClickCell(1,2), new ClickCell(2,2), new ClickCell(2,0),
                                                    new ClickCell(0,2)));

        board.setPointer(new Pointer(1,1));
        board.setBombs(Arrays.asList(new Bomb(0,0), new Bomb(0,1), new Bomb(2,2)));
    }

    @Test
    public void drawClickableCells() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(0,0));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(1,0));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(2,0));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(1,0));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(2,0));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(1,1));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(2,2));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(2,0));
        Mockito.verify(gui, Mockito.times(1)).drawClickCell(new Position(0,2));
        Mockito.verify(gui, Mockito.times(9)).drawClickCell(Mockito.any(Position.class));
    }
    @Test
    public void drawPointer() throws IOException{
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPointer(new Position(1,1));
        Mockito.verify(gui, Mockito.times(1)).drawPointer(Mockito.any(Position.class));
    }
    @Test
    public void drawBombs() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawBomb(new Position(0, 0));
        Mockito.verify(gui, Mockito.times(1)).drawBomb(new Position(0, 1));
        Mockito.verify(gui, Mockito.times(1)).drawBomb(new Position(2, 2));
        Mockito.verify(gui, Mockito.times(3)).drawBomb(Mockito.any(Position.class));
    }

    @Test
    public void refresh() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    public void clear() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
    }

 */
}
