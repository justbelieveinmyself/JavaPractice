package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.board.Board;
import com.justbelieveinmyself.ChessGame.board.BoardUtils;
import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;

import java.util.List;

public abstract class LongRangePiece extends Piece{
    public LongRangePiece(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
    @Override
    protected boolean isSlotAvailableToMove(Coordinates coordinates, Board board) {
        boolean result = super.isSlotAvailableToMove(coordinates, board);
        if (result) {
            return isSlotAvailableToAttack(coordinates, board);
        }
        return false;
    }

    @Override
    protected boolean isSlotAvailableToAttack(Coordinates coordinates, Board board) {
        List<Coordinates> slotsBetweenPieces;
        if(this.coordinates.rank.equals(coordinates.rank)) {
            slotsBetweenPieces = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
        }
        else if(this.coordinates.file.equals(coordinates.file)){
            slotsBetweenPieces = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
        }
        else{
            slotsBetweenPieces = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
        }

        for(Coordinates c : slotsBetweenPieces){
            if(!board.isSlotEmpty(c)){
                return false;
            }
        }
        return true;
    }
}
