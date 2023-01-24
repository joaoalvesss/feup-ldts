package org.minesweeper.controller.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.menu.MainMenu;

class MenuControllerTest {

    @Test
    void testConstructor() {
        MainMenu mainMenu = new MainMenu();
        MainMenu model = (new MenuController(mainMenu)).getModel();
        assertSame(mainMenu, model);
        assertEquals(3, model.getNumberEntries());
        assertFalse(model.isSelectedQuit());
        assertTrue(model.isSelectedNewGame());
        assertFalse(model.isSelectedDifficulty());
    }
}

