package org.minesweeper.states;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.menu.MainMenu;

class MenuStateTest {
    @Test
    void testConstructor() {
        MainMenu mainMenu = new MainMenu();
        assertSame(mainMenu, (new MenuState(mainMenu)).getModel());
    }

    @Test
    void testGetViewer() {
        MainMenu mainMenu = new MainMenu();
        assertSame(mainMenu, (new MenuState(mainMenu)).getViewer().getModel());
    }

    @Test
    void testGetController() {
        MainMenu mainMenu = new MainMenu();
        assertSame(mainMenu, (new MenuState(mainMenu)).getController().getModel());
    }
}

