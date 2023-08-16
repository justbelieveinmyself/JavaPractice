package com.justbelieveinmyself.Hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Scanner scanner =new Scanner(System.in);
    private List<String> usedLetters = new ArrayList<>();
    public void start(){
        int errorsCounter = 0;
        String finalWord = GameUtil.getRandomWord();
        String currentWord = "*".repeat(finalWord.length());
        while (true) {
            System.out.println(HangingStatus.values()[errorsCounter]);
            if(errorsCounter > 5){
                System.out.println("You lose!");
                break;
            }
            System.out.println(currentWord);
            System.out.println("Input your letter.");
            String s = scanner.nextLine();
            if(s.length() != 1 || usedLetters.contains(s)) {
                System.out.println("Error. Enter one letter.");
                continue;
            }
            usedLetters.add(s);
            if(finalWord.contains(s.toLowerCase())){
                System.out.println("Good job");
                int index = finalWord.indexOf(s);
                currentWord = GameUtil.getCensoredWord(currentWord, finalWord, s);
            }else{
                errorsCounter++;
            }
            if(currentWord.equals(finalWord)){
                System.out.println("GG YOU WIN!");
                break;
            }
            System.out.println("You have "+ (6-errorsCounter)  + " tries");
        }
    }
}
