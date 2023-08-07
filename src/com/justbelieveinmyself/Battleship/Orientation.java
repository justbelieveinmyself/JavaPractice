package com.justbelieveinmyself.Battleship;

import java.util.Random;

public enum Orientation {
    HORIZONTAL, VERTICAL;

    public static Orientation getRandomOrientation(){
        Random random = new Random();
        return Orientation.values()[random.nextInt(2)];
    }
    public Orientation opposite(){
        return this == HORIZONTAL ? VERTICAL : HORIZONTAL;
    }

}
