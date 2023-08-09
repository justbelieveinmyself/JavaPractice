package com.justbelieveinmyself.Battleship;

import com.justbelieveinmyself.Battleship.ships.SingleDeckShip;

import java.util.Objects;

public class Coordinates {
    public final File file;
    public final Integer rank;

    public static void main(String[] args) {
        Coordinates coordinates1 = new Coordinates(File.A, 1);
        Coordinates coordinates2 = new Coordinates(File.A, 2);
        Coordinates coordinates3 = new Coordinates(File.A, 3);
        Integer a = 1;
        Coordinates[] cord = new Coordinates[] {coordinates1, coordinates2, coordinates3};
        test(cord, a);
        for (Coordinates coordinates : cord) {
            System.out.println(coordinates);
        }
        System.out.println(a);
    }
    private static void test(Coordinates[] coordinates, Integer a){
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = coordinates[i].shift(1, 0);
            a += 1;
        }
    }
//    public static void main(String[] args) {
//        Coordinates coordinates = new Coordinates(File.A, 1);
//        Coordinates copy = coordinates;
//        System.out.println(copy.shift(1,0));
//        System.out.println(coordinates);
//    }
    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return file + " " + rank;
    }
    public Coordinates shift(int file, int rank){
        try {
            return new Coordinates(File.values()[this.file.ordinal() + file], this.rank + rank);
        }
        catch (IndexOutOfBoundsException ex){
            return null;
        }
    }
}
