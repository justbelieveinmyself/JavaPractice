package com.justbelieveinmyself.Battleship;

import java.io.Console;
import java.util.Random;

public class Main {
    private final static BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
    public static void main(String[] args) {
        Game game = new Game();
        game.startGameLoop();
        System.out.println("GAME IS OVER!");
    }
}
