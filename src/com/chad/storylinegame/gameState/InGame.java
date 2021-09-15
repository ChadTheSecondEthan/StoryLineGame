package com.chad.storylinegame.gameState;

import com.chad.engine.gameState.GameState;

import com.chad.engine.gfx.Spritesheet;
import com.chad.engine.tile.TileMap;
import com.chad.storylinegame.entity.Player;

public class InGame extends GameState {

    private final Player player;
    private final TileMap tileMap;

    public InGame() {
        super();

        readEntitiesFromFile("state/ingame.txt");

        player = new Player();
        player.spawn();

        tileMap = findEntityByName("tilemap");
        tileMap.setSpritesheet(new Spritesheet("sprites/spritesheet.png", 512 / 8));
    }

    @Override
    public void init() {

    }

}
