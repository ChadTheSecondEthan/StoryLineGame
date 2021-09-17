package com.chad.storylinegame.gameState;

import com.chad.engine.gameState.GameState;

import com.chad.engine.gfx.Spritesheet;
import com.chad.engine.tile.TileMap;
import com.chad.storylinegame.entity.Player;

public class InGame extends GameState {

    private final TileMap tileMap;
    private final Player player;

    public InGame() {
        super();

        readEntitiesFromFile("state/ingame.txt");

        tileMap = findEntityByName("tilemap");
        tileMap.setSpritesheet(new Spritesheet("sprites/spritesheet.png", 512 / 8));
        tileMap.setCollisionTypes(new short[] { 10 });

        player = new Player(tileMap);
        player.spawn();
    }

    @Override
    public void init() {}

    @Override
    public void draw() {
        super.draw();
    }

}
