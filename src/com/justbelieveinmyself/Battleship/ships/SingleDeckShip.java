package com.justbelieveinmyself.Battleship.ships;

import com.justbelieveinmyself.Battleship.Coordinates;
import com.justbelieveinmyself.Battleship.Player;

public class SingleDeckShip extends Ship{
    public SingleDeckShip(Coordinates coordinates, Player player) {
        super(coordinates, player);
        this.size = 1;
    }
}
