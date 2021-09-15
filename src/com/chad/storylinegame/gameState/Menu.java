package com.chad.storylinegame.gameState;

import com.chad.engine.Game;
import com.chad.engine.Window;
import com.chad.engine.entity.Entity;
import com.chad.engine.gameState.GameState;
import com.chad.engine.ui.Button;
import com.chad.engine.ui.Text;
import com.chad.engine.ui.UIElement;

public class Menu extends GameState {

    @Override
    public void init() {
        readEntitiesFromFile("state/menu.txt");

        for (Entity e : entities)
            ((UIElement) e).centerX();

        Button playButton = findEntityByName("play_button");
        playButton.setY(200);
        playButton.addOnClickListener(() -> Game.setState("InGame"));

        Button quitButton = findEntityByName("quit_button");
        quitButton.setY(Window.getHeight() - 200 - playButton.getHeight());
        quitButton.addOnClickListener(() -> System.exit(0));

        Button helpButton = findEntityByName("help_button");
        helpButton.centerY();
        helpButton.addOnClickListener(() -> Game.setState("Help"));
    }

}
