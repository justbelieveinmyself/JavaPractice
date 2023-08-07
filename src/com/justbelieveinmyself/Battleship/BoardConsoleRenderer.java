package com.justbelieveinmyself.Battleship;

import org.glassfish.jaxb.core.v2.model.annotation.AnnotationSource;

public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public void render(Board board){
        System.out.println( "   " + ANSI_BLACK_BACKGROUND+ ANSI_CYAN + "a  b  c  d  e  f  g  h  i  j" + ANSI_RESET);
        for (int rank = 1; rank < 11; rank++) {
            StringBuilder line = new StringBuilder();
            line.append(rank < 10 ?  " " +ANSI_BLACK_BACKGROUND + ANSI_CYAN  + rank  + ANSI_RESET : ANSI_BLACK_BACKGROUND + ANSI_CYAN + rank + ANSI_RESET);
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareEmpty(coordinates)) {
                    line.append(ANSI_WHITE_BACKGROUND + " - " + ANSI_RESET);
                }else{

                    switch(board.getShip(coordinates).getClass().getSimpleName()){
                        case "SingleDeckShip" -> line.append(ANSI_YELLOW_BACKGROUND+ ANSI_BLACK + " 1 "+ ANSI_RESET);
                        case "TwoDeckShip" -> line.append(ANSI_YELLOW_BACKGROUND+ANSI_BLACK + " 2 "+ ANSI_RESET);
                        case "ThreeDeckShip" -> line.append(ANSI_YELLOW_BACKGROUND+ANSI_BLACK + " 3 " + ANSI_RESET);
                        case "FourDeckShip" -> line.append(ANSI_YELLOW_BACKGROUND+ANSI_BLACK +" 4 "+ ANSI_RESET);
                    }

                }
            }
            System.out.println(line);
        }
    }
}
