package com.justbelieveinmyself.ChessGame;

public abstract class Piece {
    public Coordinates coordinates;
    Color color;
    public Piece(Coordinates coordinates, Color color){
        this.coordinates = coordinates;
        this.color = color;
    }
}
