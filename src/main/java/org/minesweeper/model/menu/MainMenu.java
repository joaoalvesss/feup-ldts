package org.minesweeper.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu {

    public MainMenu() {
        this.entries = Arrays.asList("New Game", "Select Difficulty", "Quit");
    }

    public boolean isSelectedNewGame() {
        return isSelected(0);
    }

    public boolean isSelectedDifficulty() {
        return isSelected(1);
    }

    public boolean isSelectedQuit() {
        return isSelected(2);
    }
}


