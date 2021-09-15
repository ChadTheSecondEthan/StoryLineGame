package com.chad.storylinegame.gameState;

import com.chad.engine.gameState.GameState;
import com.chad.storylinegame.entity.Player;

public class InGame extends GameState {

    private final Player player;

    public InGame() {
        super();

        player = new Player();
        player.spawn();
    }

    @Override
    public void init() {}

}
