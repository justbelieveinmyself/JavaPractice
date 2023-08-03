package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.King;
import com.justbelieveinmyself.ChessGame.pieces.Piece;
import com.justbelieveinmyself.ChessGame.board.Board;
import com.justbelieveinmyself.ChessGame.board.BoardConsoleRenderer;
import com.justbelieveinmyself.ChessGame.board.BoardFactory;
import com.justbelieveinmyself.ChessGame.board.Move;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    static Scanner scanner = new Scanner(System.in);
    public static Coordinates input(){
        while(true){
            System.out.println("Please enter coordinates (ex. a1)");
            String line = scanner.nextLine();

            if(line.length() != 2){
                System.out.println("Invalid format length");
                continue;
            }
            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);
            if(!Character.isAlphabetic(fileChar)){
                System.out.println("Invalid format");
                continue;
            }
            if(!Character.isDigit(rankChar)){
                System.out.println("Invalid format not digit");
                continue;
            }
            int rank = Integer.valueOf(String.valueOf(rankChar)); //Character.getNumericValue(rankChar);
            if(rank < 1 || rank > 8){
                System.out.println("Invalid format >8 || <1");
                continue;
            }
            File file = File.fromChar(fileChar);
            if(file == null){
                System.out.println("Invalid format file == null");
                continue;
            }
            return new Coordinates(file, rank);
        }
    }
    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board)
    {
        while (true) {
            System.out.println("Enter coordinates to move");
            Coordinates coordinates = input();
            if(board.isSlotEmpty(coordinates)){
                System.out.println("Empty slot");
                continue;
            }
            Piece piece = board.getPiece(coordinates);
            if(piece.color != color){
                System.out.println("Wrong color");
                continue;
            }
            Set<Coordinates> availableMoves = piece.getAvailableMoves(board);
            if(availableMoves.size() == 0 ){
                System.out.println("Blocked piece");
                continue;
            }
            return coordinates;
        }
    }
    public static Coordinates inputAvailableSlot(Set<Coordinates> coordinates)
    {
        while (true) {
            System.out.println("Please enter your move for a selected piece");
            Coordinates input = input();
            for(Coordinates c : coordinates){
                System.out.println(c.rank + "" + c.file);
            }
            if(!coordinates.contains(input)){
                System.out.println("Not available slot");
                continue;
            }
            return input;
        }
    }
    public static Move inputMove(Board board, Color color, BoardConsoleRenderer renderer){

        while(true)
        {
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(color, board);
            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableCoordinates = piece.getAvailableMoves(board);
            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSlot(availableCoordinates);
            Move move = new Move(sourceCoordinates, targetCoordinates);
            if (validateIfKingInCheckAfterMove(board, color, move)) {
                System.out.println("your king is under attack!");
                continue;
            }
            return move;
        }
    }

    private static boolean validateIfKingInCheckAfterMove(Board board, Color color, Move move) {
        Board copy = new BoardFactory().copy(board);
        copy.makeMove(move);

        //we trust that there is king on the board
        Piece king = copy.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        return copy.isSlotAttackedByColor(king.coordinates, color.opposite());
    }
}
