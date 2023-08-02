package com.justbelieveinmyself.ChessGame;

import java.util.Objects;

public class Coordinates {
    public final File file;
    public final Integer rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && Objects.equals(rank, that.rank);
    }
    public Coordinates shift(CoordinatesShift shift){
        return new Coordinates(File.values()[this.file.ordinal()  + shift.fileShift], this.rank + shift.rankShift);
    }
    public boolean canShift(CoordinatesShift shift){
        int f = this.file.ordinal() + shift.fileShift;
        int r = this.rank + shift.rankShift;
        if(f < 0 || f > 7) return false; //0,7
        if(r < 1 || r > 8) return false; //1,8

        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    public Coordinates(File file, Integer rank){
        this.file = file;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return file + "" + rank;
    }
}

