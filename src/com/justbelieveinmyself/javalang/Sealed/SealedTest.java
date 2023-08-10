package com.justbelieveinmyself.javalang.Sealed;

public class SealedTest {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", new JSONString("Harry"));
        obj.put("salary", new JSONNumber(100000));
        obj.put("married", JSONBoolean.FALSE);

        JSONArray array = new JSONArray();
        array.add(new JSONNumber(13));
        array.add(JSONNull.INSTANCE);

        obj.put("luckyNumbers", array);
        System.out.println(obj);
        System.out.println(obj.type());
    }
}
