package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;
import com.justbelieveinmyself.ChessGame.CoordinatesShift;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{
    public Knight(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPiecesMoves() {
        return new HashSet<>(Arrays.asList(
            new CoordinatesShift(1,2),
            new CoordinatesShift(2,1),
            new CoordinatesShift(2,-1),
            new CoordinatesShift(1,-2),
            new CoordinatesShift(-2,-1),
            new CoordinatesShift(-1,-2),
            new CoordinatesShift(-2,1),
            new CoordinatesShift(-1,2)
        )
        );
    }
}
