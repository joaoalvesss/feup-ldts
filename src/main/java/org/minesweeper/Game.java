package org.minesweeper;

import org.minesweeper.gui.LanternaGUI;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.states.MenuState;
import org.minesweeper.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private String difficulty = "easy"; //Default

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(38, 26);
        this.state = new MenuState(new MainMenu());
    }

    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public String getDifficulty(){
        return this.difficulty;
    }

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while(this.state != null){
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }
        gui.close();
    }
}

