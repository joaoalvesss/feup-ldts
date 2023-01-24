package org.minesweeper.states;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.menu.DifficultyMenu;

class StateTest {
    @Test
    void testGetModel() {
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        assertSame(difficultyMenu, (new DifficultyMenuState(difficultyMenu)).getModel());
    }
}

