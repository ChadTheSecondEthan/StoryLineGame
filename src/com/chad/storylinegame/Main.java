package com.chad.storylinegame;

import com.chad.engine.Game;
import com.chad.storylinegame.gameState.*;

public class Main {

    public static void main(String[] args) {
        Game.init("Story Line Game");
        Game.setStates(new Menu(), new InGame());
        Game.start(1);
    }

}
