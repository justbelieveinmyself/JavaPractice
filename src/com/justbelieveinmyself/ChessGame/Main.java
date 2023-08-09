package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.board.Board;
import com.justbelieveinmyself.ChessGame.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        BoardFactory boardFactory = new BoardFactory();
        Board board = boardFactory.fromFEN(
                //"3k4/8/p7/8/R7/8/P7/3K4 w - - 0 1"
                //"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
                //"3k4/8/8/b7/8/8/2PK4/6N1 w - - 0 1"
                // "8/8/8/8/6p1/3k1pP1/3p1P2/3K3N w - - 0 1" //пат белым
                //"k2r3R/8/8/2P1P3/2PKP3/2PPP3/8/8 w - - 0 1" //мат
                //"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1" //default
                "8/8/8/3k4/8/3K4/8/8 w - - 0 1"
                //"rnb1kbnr/pppp1ppp/4p3/8/6Pq/5P2/PPPPP2P/RNBQKBNR w KQkq - 0 1"
                // "3k4/6r1/8/1P2Q3/2B5/6P1/2R1r3/3K4 w - - 0 1"
        );
        Game game = new Game(board);
        game.gameLoop();
    }
}
