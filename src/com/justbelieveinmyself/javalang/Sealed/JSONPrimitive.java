package com.justbelieveinmyself.javalang.Sealed;

public sealed interface JSONPrimitive extends JSONValue permits JSONNumber, JSONString, JSONNull, JSONBoolean{
}
