package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Wall;
import org.minesweeper.viewer.game.WallViewer;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class WallViewerTest {
    private WallViewer wallViewer;
    private GUI gui;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;


    @BeforeEach
    public void helper(){
        wallViewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
        wall1 = new Wall(0,1, "side");
        wall2 = new Wall(4,1, "topBottom");
        wall3 = new Wall(6,1, "Edge");

    }

    @Test
    public void drawSideWall(){
        wallViewer.draw(wall1, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }

    @Test
    public void drawTopBottomWall(){
        wallViewer.draw(wall2, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }

    @Test
    public void drawEdgeWall(){
        wallViewer.draw(wall3, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }
}
