package com.justbelieveinmyself.Simulation;

import com.justbelieveinmyself.Simulation.entities.Entity;
import com.justbelieveinmyself.Simulation.entities.Herbivore;
import com.justbelieveinmyself.Simulation.entities.Predator;

public class Actions {
    private Map initActions(){
        Map map = new Map();
        map.addEntity(new Cell(0, 0), new Predator(3, 4, 2));
        map.addEntity(new Cell(2, 1), new Predator(3, 4, 2));
        map.addEntity(new Cell(5, 3), new Predator(3, 4, 2));
        map.addEntity(new Cell(9, 6), new Predator(3, 4, 2));
        map.addEntity(new Cell(4, 3), new Herbivore(3, 4));
        map.addEntity(new Cell(0, 6), new Herbivore(3, 4));
        return map;
    }

    public static void main(String[] args) {
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        Actions actions = new Actions();
        consoleRenderer.render(actions.initActions());
    }
}
