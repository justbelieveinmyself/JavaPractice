package com.justbelieveinmyself.javalang.Sealed;

enum JSONNull implements JSONPrimitive{
    INSTANCE;
    @Override
    public String toString(){
        return "null";
    }
}
