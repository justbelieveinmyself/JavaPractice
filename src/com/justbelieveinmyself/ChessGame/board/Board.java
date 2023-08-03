package com.justbelieveinmyself.ChessGame.board;

import com.justbelieveinmyself.ChessGame.Color;
import com.justbelieveinmyself.ChessGame.Coordinates;
import com.justbelieveinmyself.ChessGame.File;
import com.justbelieveinmyself.ChessGame.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Board {
    final String startingFEN;
    public List<Move> moves = new ArrayList<>();
    public Board(String startingFEN) {
        this.startingFEN = startingFEN;
    }

    public static void main(String[] args) {
        for(File file : File.values()){
            System.out.println(file.ordinal());
        }
    }
    private HashMap<Coordinates, Piece> pieces = new HashMap<>();
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
    public void makeMove(Move move){
        Piece piece = pieces.get(move.from);

        removePiece(move.from);
        piece.coordinates = move.to;
        pieces.put(move.to, piece);
        moves.add(move);
    }
    public static boolean isSlotDark(Coordinates coordinates){
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    public boolean isSlotAttackedByColor(Coordinates coordinates, Color color) {
        List<Piece> pieces = getPiecesByColor(color);
        for(Piece p : pieces){
            Set<Coordinates> availableAttacks = p.getAttackedSlots(this);
            if(availableAttacks.contains(coordinates)){
                return true;
            }
        }
        return false;
    }

    public List<Piece> getPiecesByColor(Color color) {
        List<Piece> result = new ArrayList<>();
        for(Piece p : pieces.values()){
            if(p.color == color){
                result.add(p);
            }
        }
        return result;
    }
}
