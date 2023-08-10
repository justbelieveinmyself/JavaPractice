package com.justbelieveinmyself.javalang.Sealed;

public sealed interface JSONValue permits JSONObject, JSONArray, JSONPrimitive {
    public default String type(){
        return switch (this) {
            case JSONArray j: yield "array";
            case JSONNumber j: yield "number";
            case JSONString j: yield "string";
            case JSONBoolean j: yield "boolean";
            case JSONObject j: yield "object";
            case JSONNull j: yield "null";
            case JSONPrimitive j: yield "wtf";
        };
    }
}
