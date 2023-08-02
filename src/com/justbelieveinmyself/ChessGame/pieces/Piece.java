package com.justbelieveinmyself.ChessGame.pieces;

import com.justbelieveinmyself.ChessGame.Board;
import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;
import com.justbelieveinmyself.ChessGame.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    public Coordinates coordinates;
    public Color color;
    public Piece(Coordinates coordinates, Color color){
        this.coordinates = coordinates;
        this.color = color;
    }
    public Set<Coordinates> getAvailableMoves(Board board){
        Set<Coordinates> result = new HashSet<>();
        for(CoordinatesShift shift : getPiecesMoves()){
             if(coordinates.canShift(shift)){
                 Coordinates newCoordinates = coordinates.shift(shift);
                 if(isSlotAvailableToMove(newCoordinates, board)){
                     result.add(newCoordinates);
                 }
             }
        }
        return result;
    }

    protected boolean isSlotAvailableToMove(Coordinates coordinates, Board board) { //if not enemy || empty
        return board.isSlotEmpty(coordinates) || board.getPiece(coordinates).color != color;
    }

    protected abstract Set<CoordinatesShift> getPiecesMoves();
}
