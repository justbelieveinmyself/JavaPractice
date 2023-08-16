package com.justbelieveinmyself.Simulation;

import com.justbelieveinmyself.Simulation.entities.Entity;

import java.util.HashMap;

public class Map {
    private HashMap<Cell, Entity> map = new HashMap<>();
    private static int size = 10;
    public static int getSize(){
        return size;
    }
    public void addEntity(Cell cell, Entity entity){
        map.put(cell, entity);
    }
    public boolean isEmpty(Cell cell){
        return !map.containsKey(cell);
    }

}
