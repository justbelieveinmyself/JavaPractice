package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.Piece;

public class Main {
    public static void main(String[] args) {
        BoardFactory boardFactory = new BoardFactory();
        Board board = boardFactory.fromFEN(
                //"3k4/8/p7/8/R7/8/P7/3K4 w - - 0 1"
                "3k4/6r1/8/1P2Q3/2B5/6P1/2R1r3/3K4 w - - 0 1"
        );
        Game game = new Game(board);
        game.gameLoop();
    }
}
