package org.minesweeper.viewer.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.menu.MainMenu;
import org.mockito.Mockito;

class MenuViewerTest {
    private GUI gui;

    @BeforeEach
    public void helper(){
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testConstructor() {
        MainMenu mainMenu = new MainMenu();
        MainMenu model = (new MenuViewer(mainMenu)).getModel();
        assertSame(mainMenu, model);
        assertEquals(3, model.getNumberEntries());
        assertFalse(model.isSelectedQuit());
        assertTrue(model.isSelectedNewGame());
        assertFalse(model.isSelectedDifficulty());
    }

    @Test
    void drawElementsTest() {
        MenuViewer menuViewer = new MenuViewer(new MainMenu());
        menuViewer.drawElements(gui);
        // 94 calls: 70 (15+15+20+20) from MenuBoxViewer, 20 to draw "-", 3 to draw menu entries, 1 to draw "Minesweeper"
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(13, 7), "Minesweeper", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(94)).drawText(any(Position.class), anyString(), anyString());
    }
}

