package com.justbelieveinmyself.TikTakToe;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

// player always goes first
// player always X
// bot O
// bot choose random empty cell
// no OOP (only procedure)
//indexing rows and col starts with 0
public class Main {
    private final static int ROW_COUNT = 3;
    private final static int COL_COUNT = 3;
    private static final String CELL_STATE_EMPTY = " ";
    private static final String CELL_STATE_X = "X";
    private static final String CELL_STATE_O = "O";
    private static final String GAME_STATE_X_WON = "X won!";
    private static final String GAME_STATE_O_WON = "O won!";
    private static final String GAME_STATE_DRAW = "Draw!";
    private static final String GAME_STATE_ONGOING = "Ongoing.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static void main(String[] args) {
        startGameRound();
    }
    public static void startGameRound(){
        String[][] board = createBoard();
        startGameLoop(board);
    }
    public static String[][] createBoard(){
        String[][] board = new String[ROW_COUNT][COL_COUNT];
        for(int row = 0; row < ROW_COUNT; row++){
            for(int col = 0; col < COL_COUNT; col++){
                board[row][col] = CELL_STATE_EMPTY;
//                board[row][col] = CELL_STATE_X;
            }
        }
        return board;
    }
    public static void startGameLoop(String[][] board){
        String gameState = GAME_STATE_ONGOING;
        boolean isPlayerMove = true;
        while(true){
            if(isPlayerMove) {
                makePlayerTurn(board);
            }else{
                makeBotTurn(board);
            }
            printBoard(board);
            if(!gameState.equals(checkGameState(board))){
                gameState = checkGameState(board);
                break;
            }
            isPlayerMove = !isPlayerMove;
        }
        System.out.println("GAME IS END: "+ gameState);
    }
    public static void makePlayerTurn(String[][] board){
        System.out.println("Your turn!");
        int[] coordinates = inputCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_X;
    }
    public static boolean areAllCellsTaken(String[][] board){
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                if(Objects.equals(board[row][col], CELL_STATE_EMPTY)){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[] inputCellCoordinates(String[][] board) {
        System.out.println("Enter the coordinates (EX. 1 1) (0-2)");
        do{
            String input = scanner.nextLine();
            if (input.length() != 3) {
                System.out.println("Invalid format. Length must be 3");
                continue;
            }
            if (input.charAt(1) != ' ') {
                System.out.println("Invalid format. Please enter values through space.");
                continue;
            }

            String[] splitedInput = input.split(" ");
            if(!Character.isDigit(splitedInput[0].charAt(0))|| !Character.isDigit(splitedInput[1].charAt(0))){
                System.out.println("Invalid format.");
                continue;
            }
            int row = Integer.parseInt(splitedInput[0]);
            int col = Integer.parseInt(splitedInput[1]);
            if (row > 2 || row < 0 || col > 2 || col < 0) {
                System.out.println("Invalid value. Row and col must be >0 || < 2");
                continue;
            }
            else if (!Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                System.out.println("This cell is not empty");
                continue;
            }
            else{
                return new int[]{row, col};
            }
        } while(true);
    }
    public static void makeBotTurn(String[][] board){
        System.out.println("Bot turn.");
        int[] coordinates = getRandomEmptyCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_O;
    }
    public static int[] getRandomEmptyCellCoordinates(String[][] board){
        do {
            int row = random.nextInt(ROW_COUNT);
            int col = random.nextInt(COL_COUNT);
            if (Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                return new int[]{row, col};
            }
        }while(true);
    }
    public static String checkGameState(String[][] board){
        ArrayList<Integer> sums = new ArrayList<>();
        //iterate rows
        for (int row = 0; row < ROW_COUNT; row++) {
            int rowSum = 0;
            for (int col = 0; col < COL_COUNT; col++) {
                rowSum += calculateNumericValue(board[row][col]);
            }
            sums.add(rowSum);
        }
        //iterate cols
        for (int col = 0; col < COL_COUNT; col++) {
            int colSum = 0;
            for (int row = 0; row < ROW_COUNT; row++) {
                colSum += calculateNumericValue(board[row][col]);
            }
            sums.add(colSum);
        }
        //iterate diagonal from top-left to bot-right
        int leftDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            leftDiagonalSum += calculateNumericValue(board[i][i]);
        }
        sums.add(leftDiagonalSum);
        //iterate diagonal from top-right to bot-left
        int rightDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            rightDiagonalSum += calculateNumericValue(board[i][(ROW_COUNT-1)-i]);
        }
        sums.add(rightDiagonalSum);
        if(sums.contains(3)){
            return GAME_STATE_X_WON;
        }else if(sums.contains(-3)){
            return GAME_STATE_O_WON;
        }else if(areAllCellsTaken(board)){
            return GAME_STATE_DRAW;
        }else{
            return GAME_STATE_ONGOING;
        }
        // X = 1, O = -1, Empty = 0
        //count sum for rows, columns, diagonals
        //if (sum.contains(3) -> X win
        //if (sum.contains(-3) -> O win
        //if (allCaseTaken()) -> draw
        //else -> gameNotOver
    }

    private static int calculateNumericValue(String cellState) {
        if(cellState.equals(CELL_STATE_X)){
            return 1;
        }else if(cellState.equals(CELL_STATE_O)){
            return -1;
        }else{
            return 0;
        }
    }

    public static void printBoard(String[][] board){
        System.out.println("+---+---+---+");
        for (int row = 0; row < ROW_COUNT; row++) {
            String line = "|";
            for (int col = 0; col < COL_COUNT; col++) {
                line += " "+  board[row][col] + " |";
            }
            System.out.println(line);
            System.out.println("+---+---+---+");
        }

    }
}
