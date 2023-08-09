package com.justbelieveinmyself.Battleship;

import com.justbelieveinmyself.Battleship.ships.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.min;

public class Board {

    private final HashMap<Coordinates, Ship> ships = new HashMap<>();
    private final ArrayList<Coordinates> attackedSquares = new ArrayList<>();
    private final Random random = new Random();
    private final int COUNT_OF_SINGLE_DECK = 4;
    private final int COUNT_OF_TWO_DECK = 3;
    private final int COUNT_OF_THREE_DECK = 2;
    private final int COUNT_OF_FOUR_DECK = 1;
    private final Player player;

    public Board(Player player) {
        this.player = player;
    }
    public Player getPlayer(){
        return player;
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
    private boolean isSquareInsideBoard(Coordinates coordinates){
        return coordinates.rank <= 10;
    }
    private boolean isNearSquaresEmpty(Coordinates from, Coordinates to){
        for (int rank = to.rank-1; rank <= to.rank + 1; rank++) {
            for (int fileIndex = to.file.ordinal()-1; fileIndex <= to.file.ordinal()+1; fileIndex++) {
                if((from != null && from.file.ordinal() == fileIndex && from.rank == rank) || fileIndex < 0 || fileIndex > 9 || rank > 10 || rank < 1 ){
                    continue;
                }
                if(ships.containsKey(new Coordinates(File.values()[fileIndex], rank) ) ){ // 0..9
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isSquareAttacked(Coordinates coordinates){
        return attackedSquares.contains(coordinates);
    }
    public boolean attackSquare(Coordinates coordinates){
        if(attackedSquares.contains(coordinates)) {
            System.out.println("Square already is attacked!");
            return true;
        }
        attackedSquares.add(coordinates);
        if(!isSquareEmpty(coordinates) && isShipwreck(coordinates)){
            addAllNearSquares(coordinates);
        }
        return !isSquareEmpty(coordinates);
    }
    public boolean isAllShipsDied(){
        for (Ship ship : ships.values()) {
            if(!attackedSquares.contains(ship.coordinates)){
                return false;
            }
        }
        return true;
    }
    private boolean isShipwreck(Coordinates coordinates){
        Ship ship = getShip(coordinates);
        if(ship instanceof SingleDeckShip){
            return true;
        }
        Ship[] fullShip = findFullShip(ship);
        for (Ship partShip : fullShip) {
            if(!isSquareAttacked(partShip.coordinates)){
                return false;
            }
        }
        return true;
    }
    private Ship[] findFullShip(Ship ship){
        int size = ship.getSize();
        Ship[] allShips = new Ship[size];
        allShips[0] = ship;
        int counter = 1;
        counter = findShipInDirection(ship.coordinates, 1, 0, counter, allShips);
        counter = findShipInDirection(ship.coordinates, -1, 0, counter, allShips);
        counter = findShipInDirection(ship.coordinates, 0, 1, counter, allShips);
        counter = findShipInDirection(ship.coordinates, 0, -1, counter, allShips);
        if(counter != size) System.out.println("Xxddd");
        return allShips;
    }
    private void addAllNearSquares(Coordinates coordinates){
        Ship[] fullShip = findFullShip(getShip(coordinates));
        Coordinates bowOfShip = findBowOfShip(fullShip);
        Coordinates backOfShip = findBackOfShip(fullShip);
        for (int rank = bowOfShip.rank-1; rank <= backOfShip.rank + 1; rank++) {
            for (int fileIndex = bowOfShip.file.ordinal()-1; fileIndex <= backOfShip.file.ordinal()+1; fileIndex++) {
                if(fileIndex < 0 || fileIndex > 9) continue;
                Coordinates newCoordinates = new Coordinates(File.values()[fileIndex], rank);
                attackedSquares.add(newCoordinates);
            }
        }
    }
    private Coordinates findBowOfShip(Ship[] fullShip){
        int size = fullShip[0].getSize();
        if(size == 1){
            return fullShip[0].coordinates;
        }
        Orientation orientation = Orientation.fromTwoCoordinates(fullShip[0].coordinates, fullShip[1].coordinates);
        if(orientation == Orientation.HORIZONTAL){
            int fileIndex = 11;
            for (int i = 0; i < size; i++) {
                fileIndex = Math.min(fileIndex, fullShip[i].coordinates.file.ordinal());
            }
            return new Coordinates(File.values()[fileIndex], fullShip[0].coordinates.rank);
        }else{
            int rank = 11;
            for (int i = 0; i < size; i++) {
                rank = Math.min(rank, fullShip[i].coordinates.rank);
            }
            return new Coordinates(fullShip[0].coordinates.file, rank);
        }
    }
    private Coordinates findBackOfShip(Ship[] fullShip){
        int size = fullShip[0].getSize();
        if(size == 1){
            return fullShip[0].coordinates;
        }
        Orientation orientation = Orientation.fromTwoCoordinates(fullShip[0].coordinates, fullShip[1].coordinates);
        if(orientation == Orientation.HORIZONTAL){
            int fileIndex = 0;
            for (int i = 0; i < size; i++) {
                fileIndex = Math.max(fileIndex, fullShip[i].coordinates.file.ordinal());
            }
            return new Coordinates(File.values()[fileIndex], fullShip[0].coordinates.rank);
        }else{
            int rank = 0;
            for (int i = 0; i < size; i++) {
                rank = Math.max(rank, fullShip[i].coordinates.rank);
            }
            return new Coordinates(fullShip[0].coordinates.file, rank);
        }
    }
    private int findShipInDirection(Coordinates coordinates, int fileShift, int rankShift, int counter, Ship[] fullShip){
        while(true){
            coordinates = coordinates.shift(fileShift, rankShift);
            if(isSquareEmpty(coordinates)){
                break;
            }
            if(coordinates != null && isSquareInsideBoard(coordinates)){
                fullShip[counter] = getShip(coordinates);
                counter++;
            }else{
                break;
            }

        }
        return counter;
    }
}
