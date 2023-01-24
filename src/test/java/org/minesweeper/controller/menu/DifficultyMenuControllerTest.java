package org.minesweeper.controller.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.minesweeper.model.menu.DifficultyMenu;

class DifficultyMenuControllerTest {

    @Test
    void testConstructor() {
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        DifficultyMenu model = (new DifficultyMenuController(difficultyMenu)).getModel();
        assertSame(difficultyMenu, model);
        assertEquals(3, model.getNumberEntries());
        assertFalse(model.isSelectedMedium());
        assertFalse(model.isSelectedHard());
        assertTrue(model.isSelectedEasy());
    }
}

