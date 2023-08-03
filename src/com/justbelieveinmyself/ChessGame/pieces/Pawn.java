package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.board.Board;
import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;
import com.justbelieveinmyself.ChessGame.CoordinatesShift;
import com.justbelieveinmyself.ChessGame.board.BoardUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece{
    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected Set<CoordinatesShift> getPiecesMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        if (color == Color.WHITE) {
            result.add(new CoordinatesShift(0,1));
            if(coordinates.rank == 2){
                result.add(new CoordinatesShift(0,2));
            }
            result.add(new CoordinatesShift(1,1));
            result.add(new CoordinatesShift(-1,1));
        }else{
            result.add(new CoordinatesShift(0,-1));
            if (coordinates.rank == 7) {
                result.add(new CoordinatesShift(0,-2));
            }
            result.add(new CoordinatesShift(1,-1));
            result.add(new CoordinatesShift(-1,-1));
        }
        return result;
    }

    @Override
    protected boolean isSlotAvailableToMove(Coordinates coordinates, Board board) {
        if(this.coordinates.file == coordinates.file){
            int rankShift = Math.abs(this.coordinates.rank - coordinates.rank);
            if(rankShift == 2){
                List<Coordinates> between = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
                return board.isSlotEmpty(between.get(0)) && board.isSlotEmpty(coordinates);
            }
            else {
                return board.isSlotEmpty(coordinates);
            }
        }
        else{
            if(board.isSlotEmpty(coordinates)){
                return false;
            }else{
                return board.getPiece(coordinates).color != color;
            }
        }
    }

    @Override
    protected Set<CoordinatesShift> getPiecesAttacks() {
        Set<CoordinatesShift> result = new HashSet<>();
        if (color == Color.WHITE) {
            result.add(new CoordinatesShift(1,1));
            result.add(new CoordinatesShift(-1,1));
        }else{
            result.add(new CoordinatesShift(1,-1));
            result.add(new CoordinatesShift(-1,-1));
        }
        return result;
    }
}
