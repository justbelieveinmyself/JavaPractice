package com.justbelieveinmyself.Battleship.ships;

import com.justbelieveinmyself.Battleship.Coordinates;
import com.justbelieveinmyself.Battleship.Player;

public class TwoDeckShip extends Ship{
    public TwoDeckShip(Coordinates coordinates, Player player) {
        super(coordinates, player);
        this.size = 2;
    }
}
