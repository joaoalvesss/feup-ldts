package org.minesweeper.states;

import org.minesweeper.controller.Controller;
import org.minesweeper.controller.menu.DifficultyMenuController;
import org.minesweeper.model.menu.DifficultyMenu;
import org.minesweeper.viewer.Viewer;
import org.minesweeper.viewer.menu.DifficultyMenuViewer;

public class DifficultyMenuState extends State<DifficultyMenu> {

    public DifficultyMenuState(DifficultyMenu menu) {
        super(menu);
    }

    @Override
    protected Viewer<DifficultyMenu> getViewer() {
        return new DifficultyMenuViewer(getModel());
    }

    @Override
    protected Controller<DifficultyMenu> getController() {
        return new DifficultyMenuController(getModel());
    }
    
}
