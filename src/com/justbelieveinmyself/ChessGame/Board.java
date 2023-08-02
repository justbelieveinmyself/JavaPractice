package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.*;

import java.util.HashMap;

public class Board {
    public static void main(String[] args) {
        for(File file : File.values()){
            System.out.println(file.ordinal());
        }
    }
    HashMap<Coordinates, Piece> pieces = new HashMap<>();
    public void setPiece(Coordinates coordinates, Piece piece){
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }
    public void setupDefaultPiecesPosition(){
        for(File file : File.values()){
            pieces.put(new Coordinates(file, 7), new Pawn(new Coordinates(file, 7), Color.BLACK));
            pieces.put(new Coordinates(file, 2), new Pawn(new Coordinates(file, 2), Color.WHITE));
        }

        pieces.put(new Coordinates(File.A, 8), new Rook(new Coordinates(File.A, 8), Color.BLACK));
        pieces.put(new Coordinates(File.H, 8), new Rook(new Coordinates(File.H, 8), Color.BLACK));
        pieces.put(new Coordinates(File.A, 1), new Rook(new Coordinates(File.A, 1), Color.WHITE));
        pieces.put(new Coordinates(File.H, 1), new Rook(new Coordinates(File.H, 1), Color.WHITE));

        pieces.put(new Coordinates(File.B, 8), new Knight(new Coordinates(File.B, 8), Color.BLACK));
        pieces.put(new Coordinates(File.G, 8), new Knight(new Coordinates(File.G, 8), Color.BLACK));
        pieces.put(new Coordinates(File.B, 1), new Knight(new Coordinates(File.B, 1), Color.WHITE));
        pieces.put(new Coordinates(File.G, 1), new Knight(new Coordinates(File.G, 1), Color.WHITE));

        pieces.put(new Coordinates(File.C, 8), new Bishop(new Coordinates(File.C, 8), Color.BLACK));
        pieces.put(new Coordinates(File.F, 8), new Bishop(new Coordinates(File.F, 8), Color.BLACK));
        pieces.put(new Coordinates(File.C, 1), new Bishop(new Coordinates(File.C, 1), Color.WHITE));
        pieces.put(new Coordinates(File.F, 1), new Bishop(new Coordinates(File.F, 1), Color.WHITE));

        pieces.put(new Coordinates(File.D, 8), new Queen(new Coordinates(File.D, 8), Color.BLACK));
        pieces.put(new Coordinates(File.D, 1), new Queen(new Coordinates(File.D, 1), Color.WHITE));

        pieces.put(new Coordinates(File.E, 8), new King(new Coordinates(File.E, 8), Color.BLACK));
        pieces.put(new Coordinates(File.E, 1), new King(new Coordinates(File.E, 1), Color.WHITE));
    }
    public boolean isSlotEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    }
    public Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }
    public void removePiece(Coordinates coordinates){
        pieces.remove(coordinates);
    }
    public void movePiece(Coordinates from, Coordinates to){
        Piece piece = pieces.get(from);

        removePiece(from);
        piece.coordinates = to;
        pieces.put(to, piece);

    }
    public static boolean isSlotDark(Coordinates coordinates){
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }
}
