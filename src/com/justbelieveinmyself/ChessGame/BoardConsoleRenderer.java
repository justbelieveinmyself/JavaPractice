package com.justbelieveinmyself.ChessGame;

public class Renderer {
    public void render(Board board){
        for(int rank = 8; rank >= 1; rank--){
            for(File file : File.values()){
                System.out.println(file + "" + rank);
            }
        }
    }
    public String getSpriteForEmptySlot(Coordinates coordinates){
        return " "
    }
}
