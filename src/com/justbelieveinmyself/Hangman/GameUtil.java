package com.justbelieveinmyself.Hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameUtil {

    private static List<String> readListFromFile(){
        List<String> result = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\com\\justbelieveinmyself\\Hangman\\words.txt"))){
            while(true) {
                String s = bufferedReader.readLine();
                if(s == null){
                    break;
                }
                result.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("Exception");
        }
        return result;
    }
    public static String getRandomWord(){
        Random random = new Random();
        List<String> words = readListFromFile();
        return words.get(random.nextInt(words.size())).toLowerCase();
    }

    public static String getCensoredWord(String word, String finalWord, String ch){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != '*'){
                res.append(word.charAt(i));
                continue;
            }
            if(finalWord.charAt(i) == ch.charAt(0)){
                res.replace(i, i+1, ch);
                continue;
            }
            res.append("*");
        }
        return res.toString();
    }
}
