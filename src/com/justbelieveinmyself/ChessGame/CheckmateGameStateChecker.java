package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.board.Board;
import com.justbelieveinmyself.ChessGame.board.BoardFactory;
import com.justbelieveinmyself.ChessGame.board.Move;
import com.justbelieveinmyself.ChessGame.pieces.King;
import com.justbelieveinmyself.ChessGame.pieces.Piece;

import java.util.List;
import java.util.Set;

public class CheckmateGameStateChecker extends GameStateChecker {

    @Override
    public GameState check(Board board, Color color) {
        //check if king in check
        //check that there is no move to prevent this check
        //we trust that there is king on the board
        Piece king = board.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        if(!board.isSlotAttackedByColor(king.coordinates, color.opposite())){
            return GameState.ONGOING;
        }
        List<Piece> pieces = board.getPiecesByColor(color);
        for (Piece piece : pieces) {
            Set<Coordinates> availableMoves = piece.getAvailableMoves(board);

            for (Coordinates coordinates : availableMoves) {
                Board clone = new BoardFactory().copy(board);
                clone.makeMove(new Move(piece.coordinates, coordinates));
                Piece clonedKing = clone.getPiecesByColor(color).stream().filter(p -> p instanceof King).findFirst().get();
                if(!clone.isSlotAttackedByColor(clonedKing.coordinates, color.opposite())){
                    return GameState.ONGOING;
                }

            }
            
        }
        if(color == Color.WHITE){
            return GameState.CHECKMATE_TO_WHITE_KING;
        }else{
            return GameState.CHECKMATE_TO_BLACK_KING;
        }
    }
}
