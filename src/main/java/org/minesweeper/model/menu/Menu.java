package org.minesweeper.model.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<String> entries;
    private int entryNumber = 0;

    public Menu() { this.entries = new ArrayList<>(); }

    public void nextEntry() {
        entryNumber++;
        if (entryNumber > this.entries.size() - 1)
            entryNumber = 0;
    }

    public void previousEntry() {
        entryNumber--;
        if (entryNumber < 0)
            entryNumber = this.entries.size() - 1;
    }

    public String getEntry(int n) {
        return entries.get(n);
    }

    public boolean isSelected(int n) {
        return entryNumber == n;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
