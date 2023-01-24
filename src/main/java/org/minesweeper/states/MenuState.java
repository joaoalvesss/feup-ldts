package org.minesweeper.states;

import org.minesweeper.controller.Controller;
import org.minesweeper.controller.menu.MenuController;
import org.minesweeper.model.menu.MainMenu;
import org.minesweeper.viewer.Viewer;
import org.minesweeper.viewer.menu.MenuViewer;

public class MenuState extends State<MainMenu>{

    public MenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MenuController(getModel());
    }
}
