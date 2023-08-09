package com.justbelieveinmyself.Battleship;



import java.util.Scanner;

public class InputCoordinates {
    private static Scanner scanner = new Scanner(System.in);


    public static Coordinates getInputCoordinates(){

        System.out.println("Enter coordinates (ex. a 3)");
        while(true) {
            String input = scanner.nextLine();
            if (input.length() != 3 && input.length() != 4) {
                System.out.println("Invalid format. Length of input must be 3-4!");
                continue;
            }
            String[] splitedInput = input.split(" ");
            if (!Character.isAlphabetic(splitedInput[0].charAt(0)) || !Character.isDigit(splitedInput[1].charAt(0))) {
                System.out.println("Invalid format. (ex - 'a 3')");
                continue;
            }
            Character fileChar = splitedInput[0].charAt(0);
            int rank;
            try {
                rank = Integer.parseInt(splitedInput[1]);
            }catch (NumberFormatException ignored){
                System.out.println("Invalid format");
                continue;
            }
            if(rank > 10 || rank <= 0){
                System.out.println("Invalid rank");
                continue;
            }
            File file;
            try{
                file = File.fromChar(fileChar);
            }catch (IllegalArgumentException ex){
                System.out.println("Illegal file");
                continue;
            }

            return new Coordinates(file, rank);
        }
    }
    public static Player getInputPlayerInfo(){
        System.out.println("Enter your name.");
        String name = scanner.nextLine();
        System.out.println("Enter your age.");
        int age = scanner.nextInt();
        System.out.println("Enter your country.");
        scanner.nextLine();
        String country = scanner.nextLine();
        return new Player(name, age, country);
    }
}
