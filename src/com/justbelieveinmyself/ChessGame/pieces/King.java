package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.*;
import com.justbelieveinmyself.ChessGame.board.Board;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece{
    public King(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPiecesMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        for(int fileShift = -1; fileShift <= 1; fileShift++){
            for(int rankShift = -1; rankShift <= 1; rankShift++){
                if(fileShift == 0 && rankShift == 0) continue;
                result.add(new CoordinatesShift(fileShift, rankShift));
            }
        }
        return result;
    }

    @Override
    protected boolean isSlotAvailableToMove(Coordinates coordinates, Board board) {
        boolean result = super.isSlotAvailableToMove(coordinates, board);
        if(result){
            return !board.isSlotAttackedByColor(coordinates, color.opposite());
        }
        return false;
    }
}
