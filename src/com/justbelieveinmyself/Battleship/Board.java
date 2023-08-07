package com.justbelieveinmyself.Battleship;

import com.justbelieveinmyself.Battleship.ships.*;

import java.util.HashMap;
import java.util.Random;

public class Board {

    private final HashMap<Coordinates, Ship> ships = new HashMap<>();
    private final Random random = new Random();
    private final int COUNT_OF_SINGLE_DECK = 4;
    private final int COUNT_OF_TWO_DECK = 3;
    private final int COUNT_OF_THREE_DECK = 2;
    private final int COUNT_OF_FOUR_DECK = 1;
    private final Player player;

    public Board(Player player) {
        this.player = player;
    }

    public Ship getShip(Coordinates coordinates){
        return ships.get(coordinates);
    }
    public boolean isSquareEmpty(Coordinates coordinates){
        return !ships.containsKey(coordinates);
    }
    public void setupWithRandomShipPos(){
        for (int i = 0; i < COUNT_OF_SINGLE_DECK; i++) {
            Coordinates[] coordinates = createRandomEmptyCoordinatesForNDeck(1, Orientation.getRandomOrientation());
            for (Coordinates coordinate : coordinates) {
                ships.put(coordinate, new SingleDeckShip(coordinate, player));
            }
        }
        for (int i = 0; i < COUNT_OF_TWO_DECK; i++) {
            Coordinates[] coordinates = createRandomEmptyCoordinatesForNDeck(2, Orientation.getRandomOrientation());
            for (Coordinates coordinate : coordinates) {
                ships.put(coordinate, new TwoDeckShip(coordinate, player));
            }
        }
        for (int i = 0; i < COUNT_OF_THREE_DECK; i++) {
            Coordinates[] coordinates = createRandomEmptyCoordinatesForNDeck(3, Orientation.getRandomOrientation());
            for (Coordinates coordinate : coordinates) {
                ships.put(coordinate, new ThreeDeckShip(coordinate, player));
            }
        }
        for (int i = 0; i < COUNT_OF_FOUR_DECK; i++) {
            Coordinates[] coordinates = createRandomEmptyCoordinatesForNDeck(4, Orientation.getRandomOrientation());
            for (Coordinates coordinate : coordinates) {
                ships.put(coordinate, new FourDeckShip(coordinate, player));
            }
        }
    }
    private Coordinates[] createRandomEmptyCoordinatesForNDeck(int n, Orientation orientation){
        int counter = 0;
        while(true) {
            if(counter > 150){
                orientation = orientation.opposite();
                counter = 0;
            }
            Coordinates[] coordinates = new Coordinates[n];
            while (true) {
                int fileIndex = random.nextInt(10);
                int rank = random.nextInt(10)+1;
                if (isNearSquaresEmpty(new Coordinates(File.values()[fileIndex], rank))) { //validate that all size can be located
                    coordinates[0] = new Coordinates(File.values()[fileIndex], rank);
                    break;
                }
            }
            try {
                for (int i = 1; i < coordinates.length; i++) {
                    if (orientation == Orientation.HORIZONTAL) {
                        coordinates[i] = new Coordinates(File.values()[coordinates[0].file.ordinal() + i], coordinates[0].rank);
                    } else {
                        coordinates[i] = new Coordinates(coordinates[0].file, coordinates[0].rank + i);
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException ignored){
                continue;
            }
            if(validateCoordinates(coordinates)) {
                return coordinates;
            }else{
                counter++;
            }
        }
    }

    private boolean validateCoordinates(Coordinates[] coordinates) {
        // validate that next to ship squares are empty
        for (int i = 0; i < coordinates.length-1; i++) {
            if(!isNearSquaresEmpty(coordinates[i], coordinates[i+1]) ){
                return false;
            }
        }
        // validate that ship inside the board
        for (Coordinates coordinate : coordinates) {
            if (!isSquareInsideBoard(coordinate)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNearSquaresEmpty(Coordinates coordinates){
        return isNearSquaresEmpty(null, coordinates);
    }
    private boolean isSquareInsideBoard(Coordinates coordinate){
        return coordinate.rank <= 10;
    }
    private boolean isNearSquaresEmpty(Coordinates from, Coordinates to){
        for (int rank = to.rank-1; rank <= to.rank + 1; rank++) {
            for (int fileIndex = to.file.ordinal()-1; fileIndex <= to.file.ordinal()+1; fileIndex++) {
                if((from != null && from.file.ordinal() == fileIndex && from.rank == rank) || fileIndex < 0 || fileIndex > 9 || rank > 10 || rank < 1 ){
                    continue;
                }//fileIndex < 0 || fileIndex > 9 || rank > 10 || rank < 1 ||
                if(ships.containsKey(new Coordinates(File.values()[fileIndex], rank) ) ){ // 0..9
                    return false;
                }
            }
        }
        return true;
    }
}
