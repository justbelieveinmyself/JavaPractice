package com.justbelieveinmyself.Battleship;

public class Player {
    private static int idCouter = 1;
    private int id ;
    private String name;
    private int age;
    private String country;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public Player(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
        id = idCouter++;
    }


}
