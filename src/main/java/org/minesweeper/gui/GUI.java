package org.minesweeper.gui;

import org.minesweeper.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawText(Position position, String text, String color);

    void drawPointer(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {NONE, QUIT, SELECT, UP, DOWN, LEFT, RIGHT, FLAG}
}
