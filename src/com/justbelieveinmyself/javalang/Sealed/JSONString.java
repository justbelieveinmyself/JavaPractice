package com.justbelieveinmyself.javalang.Sealed;

record JSONString(String value) implements JSONPrimitive {
    @Override
    public String toString(){
        return value;
    }
}
