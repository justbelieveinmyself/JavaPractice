package com.justbelieveinmyself.Simulation.entities;

import com.justbelieveinmyself.Simulation.entities.Creature;

public class Predator extends Creature {
    private int damage;

    public Predator(int speed, int healPoints, int damage) {
        super(speed, healPoints);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }



    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    void makeMove() {

    }
}
