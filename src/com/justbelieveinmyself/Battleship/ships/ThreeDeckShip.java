package com.justbelieveinmyself.Battleship.ships;

import com.justbelieveinmyself.Battleship.Coordinates;
import com.justbelieveinmyself.Battleship.Player;

public class ThreeDeckShip extends Ship{
    public ThreeDeckShip(Coordinates coordinates, Player player) {
        super(coordinates, player);
        this.size = 3;
    }
}
