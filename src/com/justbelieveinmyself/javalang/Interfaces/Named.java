package com.justbelieveinmyself.javalang.Interfaces;

public interface Named {
    default String getName(){
        return "named implement";
    }
}
