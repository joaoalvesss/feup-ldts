package org.minesweeper.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    public void createMenu() {
        mainMenu = new MainMenu();
    }

    @Test
    public void menuCreation() {
        assertTrue(mainMenu.isSelectedNewGame());
    }

    @Test
    public void nextEntry() {
        mainMenu.nextEntry();
        assertTrue(mainMenu.isSelectedDifficulty());
    }

    @Test
    public void previousEntry() {
        mainMenu.previousEntry();
        assertTrue(mainMenu.isSelectedQuit());
    }
}