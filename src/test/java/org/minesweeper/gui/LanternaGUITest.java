package org.minesweeper.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.ClickCell;
import org.mockito.Mock;
import org.mockito.Mockito;

public class LanternaGUITest {
    private TextGraphics tg;
    private LanternaGUI gui;

    @BeforeEach
    void helper(){
        Screen screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        gui = new LanternaGUI(screen);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
    }


    @Test
    public void drawText(){
        gui.drawText(new Position(1,1), "String text", "#000000");
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(tg, Mockito.times(1)).putString(1,1,"String text", SGR.BOLD);
    }

    @Test
    public void drawPointer(){
        gui.drawPointer(new Position(6,2), "O", "#33FFE6");
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#33FFE6"));
        Mockito.verify(tg, Mockito.times(1)).putString(6,2,"O", SGR.BOLD, SGR.BLINK);
    }
}
