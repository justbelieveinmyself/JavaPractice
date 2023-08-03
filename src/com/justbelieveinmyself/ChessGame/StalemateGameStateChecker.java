package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.Piece;
import com.justbelieveinmyself.ChessGame.board.Board;

import java.util.List;
import java.util.Set;

public class StalemateGameStateChecker extends GameStateChecker{
    @Override
    public GameState check(Board board, Color color) {
        List<Piece> pieces = board.getPiecesByColor(color);
        for (Piece piece : pieces) {
            Set<Coordinates> availableMoves = piece.getAvailableMoves(board);
            if(availableMoves.size() > 0){
                return GameState.ONGOING;
            }
        }
        return GameState.STALEMATE;
    }
}
