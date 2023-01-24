package org.minesweeper.viewer.game;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.FlagCounter;
import org.minesweeper.model.game.elements.Wall;
import org.minesweeper.viewer.game.CounterViewer;
import org.minesweeper.viewer.game.WallViewer;
import org.mockito.Mockito;
import org.w3c.dom.css.Counter;

class CounterViewerTest {
    private CounterViewer counterViewer;
    private TextGraphics tg;
    private GUI gui;

    @BeforeEach
    public void helper(){
        counterViewer = new CounterViewer(new FlagCounter(10));
        Screen screen = Mockito.mock(Screen.class);
        gui = Mockito.mock(GUI.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
    }

    @Test
    void testConstructor() {
        FlagCounter flagCounter = new FlagCounter(3);
        assertSame(flagCounter, (new CounterViewer(flagCounter)).getModel());
    }

    @Test
    public void testDraw(){
        counterViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(any(Position.class), anyString(), anyString());
    }
}

