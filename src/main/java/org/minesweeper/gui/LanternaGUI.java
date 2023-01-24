package org.minesweeper.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.minesweeper.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private TerminalSize terminalSize;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws FontFormatException, IOException, URISyntaxException {
        terminalSize = new TerminalSize(width, height);
        Terminal terminal = createTerminal(loadMineSweeperFont());
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.setCursorPosition(null);
        return screen;
    }

    private Terminal createTerminal(AWTTerminalFontConfiguration fontConfiguration) throws IOException{
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorTitle("Minesweeper");
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadMineSweeperFont() throws URISyntaxException, FontFormatException, IOException{
        URL resource = getClass().getClassLoader().getResource("Square-Regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.PLAIN, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text, SGR.BOLD);
    }

    public void drawPointer(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text, SGR.BOLD, SGR.BLINK);
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if ((keyStroke.getKeyType() == KeyType.ArrowUp) || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'w'))
            return ACTION.UP;
        if ((keyStroke.getKeyType() == KeyType.ArrowRight) || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'd'))
            return ACTION.RIGHT;
        if ((keyStroke.getKeyType() == KeyType.ArrowDown) || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's'))
            return ACTION.DOWN;
        if ((keyStroke.getKeyType() == KeyType.ArrowLeft) || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'a'))
            return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'f') return ACTION.FLAG;

        return ACTION.NONE;
    }

}


