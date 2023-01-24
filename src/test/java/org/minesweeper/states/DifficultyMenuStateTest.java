package org.minesweeper.states;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.menu.DifficultyMenu;

class DifficultyMenuStateTest {

    @Test
    void testConstructor() {
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        assertSame(difficultyMenu, (new DifficultyMenuState(difficultyMenu)).getModel());
    }

    @Test
    void testGetViewer() {
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        assertSame(difficultyMenu, (new DifficultyMenuState(difficultyMenu)).getViewer().getModel());
    }

    @Test
    void testGetController() {
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        assertSame(difficultyMenu, (new DifficultyMenuState(difficultyMenu)).getController().getModel());
    }
}

