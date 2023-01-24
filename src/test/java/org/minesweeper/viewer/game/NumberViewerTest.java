package org.minesweeper.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Number;
import org.minesweeper.viewer.game.NumberViewer;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class NumberViewerTest {
    private Number number;
    private NumberViewer viewer;
    private GUI gui;

    @BeforeEach
    void helper(){
        number = new Number(3,3);
        viewer = new NumberViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void drawNumber(){
        viewer.draw(number, gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }
}
