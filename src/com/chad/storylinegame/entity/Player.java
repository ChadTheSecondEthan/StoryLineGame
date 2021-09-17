package com.chad.storylinegame.entity;

import com.chad.engine.Window;
import com.chad.engine.entity.ColorRenderer;
import com.chad.engine.entity.Entity;
import com.chad.engine.tile.TileMap;
import com.chad.engine.utils.Keyboard;
import com.chad.engine.utils.Rectf;

import java.awt.Color;

public class Player extends Entity {

    enum Direction { UP, DOWN, LEFT, RIGHT, NONE }

    private static final float VELOCITY = 300;

    private final TileMap tileMap;
    private Direction dir;

    public Player(TileMap tileMap) {
        super();

        this.tileMap = tileMap;

        width = height = 50;
        drawable = new ColorRenderer(Color.green);

        dir = Direction.NONE;
    }

    @Override
    public void update(float dt) {

        // movement
        if (Keyboard.UP.down()) {
            setRelativeY(getRelativeY() - VELOCITY * dt);
            dir = Direction.UP;
        }
        if (Keyboard.RIGHT.down()) {
            setRelativeX(getRelativeX() + VELOCITY * dt);
            dir = Direction.RIGHT;
        }
        if (Keyboard.DOWN.down()) {
            setRelativeY(getRelativeY() + VELOCITY * dt);
            dir = Direction.DOWN;
        }
        if (Keyboard.LEFT.down()) {
            setRelativeX(getRelativeX() - VELOCITY * dt);
            dir = Direction.LEFT;
        }

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
