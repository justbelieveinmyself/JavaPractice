package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.Pawn;
import com.justbelieveinmyself.ChessGame.pieces.Piece;

public class BoardFactory {
    private final PieceFactory pieceFactory = new PieceFactory();
    public Board fromFEN(String fullFEN){
        Board board = new Board();
        // rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
        String fen = fullFEN.split(" ")[0];
        String[] fenRows = fen.split("/");
        for(int j = 0; j < fenRows.length; j++){
            String fenRow = fenRows[j];
            int rank = 8-j;
            int fileIndex = 0;
            for(int i = 0; i < fenRow.length(); i++){
                char fenChar = fenRow.charAt(i);
                if(Character.isDigit(fenChar)){
                    fileIndex += Character.getNumericValue(fenChar);
                }else{

                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file, rank);

                    Piece piece = pieceFactory.fromFENChar(fenChar, coordinates);
                    board.setPiece(coordinates, piece);

                    fileIndex++;
                }
            }
        }

        return board;
    }
}
