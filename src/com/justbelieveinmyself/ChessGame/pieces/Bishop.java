package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop {
    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPiecesMoves() {
        return getBishopMoves();
    }

}
