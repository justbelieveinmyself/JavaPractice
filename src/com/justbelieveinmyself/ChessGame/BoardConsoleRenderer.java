package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;

public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SLOT_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SLOT_BACKGROUND = "\u001B[0;100m";
    public static final String ANSI_HIGHLIGHTED_SLOT_BACKGROUND = "\u001B[45m";
    public void render(Board board, Piece pieceToMove){
        Set<Coordinates> availableMoveSlots = emptySet();
        if(pieceToMove != null) {
            availableMoveSlots = pieceToMove.getAvailableMoves(board);
        }

        for(int rank = 8; rank >= 1; rank--){
            StringBuilder line = new StringBuilder();
            for(File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighlight = availableMoveSlots.contains(coordinates);
                if(board.isSlotEmpty(coordinates)) {
                    line.append(getSpriteForEmptySlot(coordinates, isHighlight));
                }
                else{
                    line.append(getPieceSprite(board.getPiece(coordinates), isHighlight));
                }
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
    }
    public void render(Board board){
        render(board, null);
    }
    private String getPieceSprite(Piece piece, boolean isHighlighted) {
        return colorizeSprite(" "+ selectUnicodeSpriteForPiece(piece) +" ", piece.color, Board.isSlotDark(piece.coordinates), isHighlighted);
    }
    private char selectUnicodeSpriteForPiece(Piece piece){
        switch(piece.getClass().getSimpleName()){
            case "Pawn": return 'P'; // ♙
            case "Knight": return 'k'; //♘
            case "Queen": return 'Q'; // ♕
            case "Bishop": return 'B'; //♗
            case "King": return 'K'; //♔
            case "Rook": return 'R'; //♕
            default: return ' ';
        }
    }
    private String colorizeSprite(String sprite, Color pieceColor, boolean isSlotDark, boolean isHighlighted){
        // background color + font color + text
        String result = sprite;
        if(pieceColor == Color.WHITE){
            result = ANSI_WHITE_PIECE_COLOR + result;
        }
        else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }
        if (isHighlighted) {
            result = ANSI_HIGHLIGHTED_SLOT_BACKGROUND + result;
        } else if(isSlotDark){
            result = ANSI_BLACK_SLOT_BACKGROUND + result;
        }
        else{
            result = ANSI_WHITE_SLOT_BACKGROUND + result;
        }
        return result;
    }
    private String getSpriteForEmptySlot(Coordinates coordinates, boolean isHighlight){
        return colorizeSprite("   ", Color.WHITE, Board.isSlotDark(coordinates), isHighlight);
    }
}
