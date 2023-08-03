package com.justbelieveinmyself.ChessGame.board;

import com.justbelieveinmyself.ChessGame.Coordinates;

public class Move {
    public final Coordinates from, to;

    public Move(Coordinates from, Coordinates to) {
        this.from = from;
        this.to = to;
    }
}
