package com.justbelieveinmyself.Battleship.ships;

import com.justbelieveinmyself.Battleship.Coordinates;
import com.justbelieveinmyself.Battleship.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    public final Coordinates coordinates;
    public final Player player;
    protected int size = 1;

    //private int size;
    protected Ship(Coordinates coordinates, Player player) {
        this.coordinates = coordinates;
        this.player = player;
    }
    public int getSize(){
        return size;
    }
    @Override
    public String toString() {
        return "Ship{" +
                "coordinates=" + coordinates +
                ", player=" + player +
//                ", size=" + size +
                '}';
    }

}
