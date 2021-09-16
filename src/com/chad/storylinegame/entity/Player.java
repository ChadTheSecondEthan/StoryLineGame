package com.chad.storylinegame.entity;

import com.chad.engine.Window;
import com.chad.engine.entity.ColorRenderer;
import com.chad.engine.entity.Entity;
import com.chad.engine.tile.TileMap;
import com.chad.engine.utils.Keyboard;
import com.chad.engine.utils.Rectf;

import java.awt.Color;

public class Player extends Entity {

    private static final float VELOCITY = 300;

    private final TileMap tileMap;

    public Player(TileMap tileMap) {
        super();

        this.tileMap = tileMap;

        width = height = 50;
        drawable = new ColorRenderer(Color.green);
    }

    @Override
    public void update(float dt) {

        // movement
        if (Keyboard.UP.down())
            setRelativeY(getRelativeY() - VELOCITY * dt);
        if (Keyboard.RIGHT.down())
            setRelativeX(getRelativeX() + VELOCITY * dt);
        if (Keyboard.DOWN.down())
            setRelativeY(getRelativeY() + VELOCITY * dt);
        if (Keyboard.LEFT.down())
            setRelativeX(getRelativeX() - VELOCITY * dt);

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

        checkTileMapCollisions(tileMap);
    }

    @Override
    public void checkCollisions(Rectf other) {
        Rectf bounds = getBounds();

        System.out.println("x: " + other.x + ", y: " + other.y);

        float right = bounds.x + bounds.w;
        float bottom = bounds.y + bounds.h;

        float obottom = other.y + other.h;

        if (right > other.x && right < other.x + other.w / 2 &&
            bottom > other.y && bounds.y < obottom) {
            setX(other.x - bounds.w);
        }
    }

}
