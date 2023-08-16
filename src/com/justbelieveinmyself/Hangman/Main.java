package com.justbelieveinmyself.Hangman;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) { //5
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter '[Nn]ew game' to start playing or smth to stop");
            String line = scanner.nextLine();
            boolean check = line.matches("[Nn].*");
            if (check) {
                System.out.println("starting game!");
                Game game = new Game();
                game.start();
            } else {
                System.out.println("Thx for playing!");
                System.exit(0);
            }
        }
    }
}
