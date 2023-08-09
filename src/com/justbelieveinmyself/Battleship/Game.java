package com.justbelieveinmyself.Battleship;

public class Game {
    private Board firstPlayerBoard;
    private Board secondPlayerBoard;
    private Board currentBoard;
    private BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
    private InputCoordinates inputCoordinates = new InputCoordinates();
    public void startGameLoop(){
        boolean isFirstPlayerTurn = true;
        Player firstPlayer = InputCoordinates.getInputPlayerInfo();
        Player secondPlayer = InputCoordinates.getInputPlayerInfo();
        firstPlayerBoard = new Board(firstPlayer);
        secondPlayerBoard = new Board(secondPlayer);
        firstPlayerBoard.setupWithRandomShipPos();
        secondPlayerBoard.setupWithRandomShipPos();
        currentBoard = secondPlayerBoard; //first player will use second player board
        while(true){
            Player currentPlayer = currentBoard.getPlayer();
            boardConsoleRenderer.render(currentBoard);
            boardConsoleRenderer.renderForAttack(currentBoard);
            doAttackMove();
            if(currentBoard.isAllShipsDied()){
                break;
            }
            boardConsoleRenderer.render(currentBoard);
            boardConsoleRenderer.renderForAttack(currentBoard);
            System.out.println("3 sec to observe board");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isFirstPlayerTurn = !isFirstPlayerTurn;
            if(isFirstPlayerTurn) {
                currentBoard = secondPlayerBoard;
            }else {
                currentBoard = firstPlayerBoard;
            }
            BoardConsoleRenderer.clear();
            System.out.println(currentPlayer.getName() + "'s turn. You have 5 seconds to switch with another player!");
            BoardConsoleRenderer.waitSwapPlayers(5);
        }
        System.out.println("RESULTS:");
        boardConsoleRenderer.render(firstPlayerBoard);
        boardConsoleRenderer.renderForAttack(firstPlayerBoard);
        boardConsoleRenderer.render(secondPlayerBoard);
        boardConsoleRenderer.renderForAttack(secondPlayerBoard);
        System.out.println(currentBoard.getPlayer().getName() + "'s lose. Thank for playing");


    }
    private void doAttackMove(){
        while(true){
            Coordinates coordinates = InputCoordinates.getInputCoordinates();
            if(!currentBoard.attackSquare(coordinates)){
                return;
            }
            boardConsoleRenderer.render(currentBoard);
            boardConsoleRenderer.renderForAttack(currentBoard);
            //check
            if(currentBoard.isAllShipsDied()){
                return;
            }
        }
    }
}
