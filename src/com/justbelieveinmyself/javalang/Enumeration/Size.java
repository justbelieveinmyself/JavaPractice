package com.justbelieveinmyself.javalang.Enumeration;

public enum Size { //extends Enum (abstract class)
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("EL"); // must be first statement
    Size(String abbreviation){ //always private
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    private String abbreviation;
}
