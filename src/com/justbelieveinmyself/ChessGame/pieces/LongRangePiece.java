package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.Board;
import com.justbelieveinmyself.ChessGame.BoardUtils;
import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;

import java.util.List;
import java.util.Objects;

public abstract class LongRangePiece extends Piece{
    public LongRangePiece(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
    @Override
    protected boolean isSlotAvailableToMove(Coordinates coordinates, Board board) {
        boolean result = super.isSlotAvailableToMove(coordinates, board);
        if (result) {
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
        return false;
    }
}
