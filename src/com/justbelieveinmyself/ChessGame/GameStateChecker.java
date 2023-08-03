package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.board.Board;

public abstract class GameStateChecker {
    public abstract GameState check(Board board, Color color);
}
