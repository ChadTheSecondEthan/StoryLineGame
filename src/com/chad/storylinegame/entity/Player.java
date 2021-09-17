package com.chad.storylinegame.entity;

import com.chad.engine.Window;
import com.chad.engine.entity.ColorRenderer;
import com.chad.engine.entity.Entity;
import com.chad.engine.gfx.Camera;
import com.chad.engine.gfx.Renderer;
import com.chad.engine.tile.TileMap;
import com.chad.engine.utils.Keyboard;
import com.chad.engine.utils.Vector2;

import java.awt.Color;

public class Player extends Entity {

    private static final float VELOCITY = 300;

    private final TileMap tileMap;
    private final Camera camera;

    public Player(TileMap tileMap) {
        super();

        this.tileMap = tileMap;
        this.camera = new Camera();
        Renderer.camera = this.camera;

        width = height = 50;
        drawable = new ColorRenderer(Color.green);
    }

    @Override
    public void update(float dt) {

        // movement
        float dx = 0;
        float dy = 0;
        if (Keyboard.UP.down())
            dy += - VELOCITY * dt;
        if (Keyboard.RIGHT.down())
            dx += VELOCITY * dt;
        if (Keyboard.DOWN.down())
            dy += VELOCITY * dt;
        if (Keyboard.LEFT.down())
            dx += -VELOCITY * dt;

        Renderer.camera.x += dx;
        Renderer.camera.y += dy;

        setRelativeX(getRelativeX() + dx);
        setRelativeY(getRelativeY() + dy);

        // collisions x
        if (getX() + width > Window.getWidth())
            setX(Window.getWidth() - width);
        else if (getX() < 0)
            setX(0);

        // collisions y
        if (getY() + height > Window.getHeight())
            setY(Window.getHeight() - height);
        else if (getY() < 0)
            setY(0);

        // update collisions
        checkTileMapCollisions(tileMap);
    }

}
