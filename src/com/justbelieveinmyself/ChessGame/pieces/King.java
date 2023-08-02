package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;
import com.justbelieveinmyself.ChessGame.CoordinatesShift;

import java.util.Set;

public class King extends Piece{
    public King(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPiecesMoves() {
        return null;
    }
}
