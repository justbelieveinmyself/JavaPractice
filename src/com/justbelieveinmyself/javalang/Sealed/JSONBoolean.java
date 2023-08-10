package com.justbelieveinmyself.javalang.Sealed;

enum JSONBoolean implements JSONPrimitive{
    FALSE, TRUE;
    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}