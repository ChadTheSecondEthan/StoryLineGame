package com.chad.storylinegame.entity;

import com.chad.engine.Window;
import com.chad.engine.entity.ColorRenderer;
import com.chad.engine.entity.Entity;
import com.chad.engine.utils.Keyboard;

import java.awt.Color;

public class Player extends Entity {

    private static final float VELOCITY = 300;

    public Player() {
        super();

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
    }

}
