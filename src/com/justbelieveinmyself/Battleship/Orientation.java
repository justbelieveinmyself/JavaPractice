package com.justbelieveinmyself.Battleship;

import java.util.Objects;
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
    public static Orientation fromTwoCoordinates(Coordinates first, Coordinates second){
        if(Objects.equals(first.rank, second.rank)){
            return HORIZONTAL;
        }else{
            return VERTICAL;
        }
    }
}
