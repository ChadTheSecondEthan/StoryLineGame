package com.chad.storylinegame.gameState;

import com.chad.engine.gameState.GameState;
import com.chad.engine.ui.Text;

public class Menu extends GameState {

    public Menu() {
        super();

        readEntitiesFromFile("state/menu.txt");
    }

    @Override
    public void init() {
    }

}
