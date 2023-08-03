package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.board.Board;
import com.justbelieveinmyself.ChessGame.board.BoardConsoleRenderer;
import com.justbelieveinmyself.ChessGame.board.Move;

import java.util.List;

public class Game {
    private final Board board;
    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();
    private final List<GameStateChecker> checkers = List.of(new StalemateGameStateChecker(), new CheckmateGameStateChecker());
    public Game(Board board){
        this.board = board;
    }
    public void gameLoop(){

        Color colorToMove = Color.WHITE;

        GameState state = determineGameState(board, colorToMove);
        while(state == GameState.ONGOING){
            if(colorToMove == Color.WHITE) System.out.println("White to move");
            else System.out.println("Black to move");
            //render
            renderer.render(board);
            //input
            Move move = InputCoordinates.inputMove(board, colorToMove, renderer);
            board.makeMove(move);
            //pass move
            colorToMove = colorToMove.opposite();

            determineGameState(board, colorToMove);

        }
        renderer.render(board);
        System.out.println("GAME ENDED WITH STATE: " + state);
    }

    private GameState determineGameState(Board board, Color color) {
        for (GameStateChecker checker : checkers) {
            GameState state = checker.check(board, color);
            if(state != GameState.ONGOING){
                return state;
            }
        }
        return GameState.ONGOING;
    }
}
