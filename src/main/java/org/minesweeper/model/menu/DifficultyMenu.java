package org.minesweeper.model.menu;

import java.util.Arrays;

public class DifficultyMenu extends Menu {

    public DifficultyMenu() {
        this.entries = Arrays.asList("Easy", "Medium", "Hard");
    }

    public boolean isSelectedEasy() {
        return isSelected(0);
    }

    public boolean isSelectedMedium() {
        return isSelected(1);
    }

    public boolean isSelectedHard() {
        return isSelected(2);
    }

}
