package org.minesweeper.viewer.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Test;
import org.minesweeper.gui.GUI;
import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.Position;
import org.minesweeper.model.menu.DifficultyMenu;
import org.mockito.Mockito;

public class DifficultyMenuViewerTest {

    @Test
    void testConstructor() {
        DifficultyMenu difficultyMenu = new DifficultyMenu();
        DifficultyMenu model = (new DifficultyMenuViewer(difficultyMenu)).getModel();
        assertSame(difficultyMenu, model);
        assertEquals(3, model.getNumberEntries());
        assertFalse(model.isSelectedMedium());
        assertFalse(model.isSelectedHard());
        assertTrue(model.isSelectedEasy());
    }

    @Test
    void drawElementsTest() {
        DifficultyMenuViewer difficultyMenuViewer = new DifficultyMenuViewer(new DifficultyMenu());
        GUI gui = Mockito.mock(LanternaGUI.class);
        difficultyMenuViewer.drawElements(gui);
        // 94 calls: 70 (15+15+20+20) from MenuBoxViewer, 20 to draw "-", 3 for the menu entries, 1 to draw "Menu"
        Mockito.verify(gui, Mockito.times(94)).drawText(any(Position.class), anyString(), anyString());
    }

}
