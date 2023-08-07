package com.justbelieveinmyself.Battleship;

public enum File {
    A, B, C, D, E, F, G, H, I, J;
    static File fromChar(Character fileChar){
        String file = fileChar + "";
        return File.valueOf(file.toUpperCase());
    }
}
