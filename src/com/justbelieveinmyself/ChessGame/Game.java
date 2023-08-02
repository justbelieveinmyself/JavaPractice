package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.Piece;

import java.util.Set;

public class Game {
    private final Board board;
    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();
    public Game(Board board){
        this.board = board;
    }
    public void gameLoop(){
        boolean isWhiteToMove = true;
        while(true){
            if(isWhiteToMove) System.out.println("White to move");
            else System.out.println("Black to move");
            //render
            renderer.render(board);
            //input
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(isWhiteToMove ? Color.WHITE : Color.BLACK, board);
            //make move
            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableCoordinates = piece.getAvailableMoves(board);
            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSlot(availableCoordinates);
            board.movePiece(sourceCoordinates, targetCoordinates);
            //pass move
            isWhiteToMove = !isWhiteToMove;


        }
    }
}
