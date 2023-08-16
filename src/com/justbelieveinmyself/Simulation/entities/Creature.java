package com.justbelieveinmyself.Simulation.entities;

public abstract class Creature extends Entity {
    private int speed;
    private int healPoints;

    public Creature(int speed, int healPoints) {
        this.speed = speed;
        this.healPoints = healPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    abstract void makeMove();

}
