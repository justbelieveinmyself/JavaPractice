package com.justbelieveinmyself.ChessGame;

import com.justbelieveinmyself.ChessGame.pieces.Piece;

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
}
