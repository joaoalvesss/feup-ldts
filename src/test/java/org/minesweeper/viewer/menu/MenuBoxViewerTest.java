package org.minesweeper.viewer.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.menu.MenuBox;

public class MenuBoxViewerTest {

    @Test
    void testConstructor() {
        Position position = new Position(1, 1);

        MenuBox menuBox = new MenuBox(position, 1, 1);

        MenuBox model = (new MenuBoxViewer(menuBox)).getModel();
        assertSame(menuBox, model);
        assertEquals(1, model.height());
        assertEquals(1, model.width());
        Position startResult = model.start();
        assertSame(position, startResult);
        assertEquals(1, startResult.getX());
        assertEquals(1, startResult.getY());
    }

    @Test
    void testDrawElements1() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(2);
        when(position.getY()).thenReturn(3);
        MenuBoxViewer menuBoxViewer = new MenuBoxViewer(new MenuBox(position, 1, 1));
        GUI gui = mock(GUI.class);
        doNothing().when(gui).drawText((Position) any(), (String) any(), (String) any());
        menuBoxViewer.drawElements(gui);
        verify(position, atLeast(1)).getX();
        verify(position, atLeast(1)).getY();
        verify(gui, atLeast(1)).drawText((Position) any(), (String) any(), (String) any());
    }

    @Test
    void testDrawElements2() {
        Position position = mock(Position.class);
        when(position.getX()).thenReturn(2);
        when(position.getY()).thenReturn(3);
        MenuBoxViewer menuBoxViewer = new MenuBoxViewer(new MenuBox(position, 3, 1));
        GUI gui = mock(GUI.class);
        doNothing().when(gui).drawText((Position) any(), (String) any(), (String) any());
        menuBoxViewer.drawElements(gui);
        verify(position, atLeast(1)).getX();
        verify(position, atLeast(1)).getY();
        verify(gui, atLeast(1)).drawText((Position) any(), (String) any(), (String) any());
    }
}
