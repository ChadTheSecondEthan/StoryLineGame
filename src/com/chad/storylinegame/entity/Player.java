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

        checkCollisions(tileMap.getTileBounds(1, 0));
    }

    @Override
    public void checkCollisions(Rectf other) {
        float x = getX();
        float y = getY();

        float right = x + width;
        float bottom = y + height;
        float xmiddle = x + width * 0.5f;
        float ymiddle = y + height * 0.5f;

        float obottom = other.y + other.h;
        float oright = other.x + other.w;
        float oxmiddle = other.x + other.w * 0.5f;
        float oymiddle = other.y + other.y * 0.5f;

        // make sure the bounds are intersecting
        if (!(right > other.x && x < oright && bottom > other.y && y < obottom))
            return;

        float colleft = right - other.x;
        float colright = oright - x;

        float coltop = obottom - y;
        float colbottom = bottom - other.y;

        float colx = Math.min(colleft, colright);
        float coly = Math.min(coltop, colbottom);

        if (colx > coly) {
            if (dir == Direction.UP)
                setY(obottom);
            else if (dir == Direction.DOWN)
                setY(other.y - height);
        }
        else {
            if (dir == Direction.RIGHT)
                setX(other.x - width);
            else if (dir == Direction.LEFT)
                setX(oright);
        }


//        if (bottom > other.y && bounds.y < obottom) {
//            if (right > other.x && right < omiddle) {
//                setX(other.x - bounds.w);
//            } else if (bounds.x < oright && bounds.x > omiddle)
//                setX(oright);
//        }
    }

}
