package com.justbelieveinmyself.Simulation;

import com.justbelieveinmyself.Simulation.entities.Entity;


public class ConsoleRenderer {
    public void render(Map map){
        for(int i = 0; i < Map.getSize(); i++){
            for (int j = 0; j < Map.getSize(); j++) {
                Cell cell = new Cell(i, j);
                if(!map.isEmpty(cell)){
                    System.out.print(" - ");
                }else{
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }
}
