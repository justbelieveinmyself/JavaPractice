package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.*;

public class PieceFactory {
    public Piece fromFENChar(char fenChar, Coordinates coordinates){
        // rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
        switch(fenChar){
            case 'r':
                return new Rook(coordinates, Color.BLACK);
            case 'R':
                return new Rook(coordinates, Color.WHITE);
            case 'n':
                return new Knight(coordinates, Color.BLACK);
            case 'N':
                return new Knight(coordinates, Color.WHITE);
            case 'b':
                return new Bishop(coordinates, Color.BLACK);
            case 'B':
                return new Bishop(coordinates, Color.WHITE);
            case 'q':
                return new Queen(coordinates, Color.BLACK);
            case 'Q':
                return new Queen(coordinates, Color.WHITE);
            case 'k':
                return new King(coordinates, Color.BLACK);
            case 'K':
                return new King(coordinates, Color.WHITE);
            case 'p':
                return new Pawn(coordinates, Color.BLACK);
            case 'P':
                return new Pawn(coordinates, Color.WHITE);
            default:
                throw new IllegalArgumentException("Bad fen");
        }
    }
}
