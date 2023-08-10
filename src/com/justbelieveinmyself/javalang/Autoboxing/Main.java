package com.justbelieveinmyself.javalang.Autoboxing;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) {
        //var listOfIntegers = new ArrayList<int>(); //error
        var listOfIntegers = new ArrayList<Integer>(); //  is far less efficient than an int[]
        listOfIntegers.add(3); // THIS IS AUTOBOXING equivalent listOfIntegers.add(Integer.valueOf(3));
        int n = listOfIntegers.get(0); // THIS IS AUTO UNBOXING listOfIntegers.get(0).intValue();

        Integer m = 3;
        m++; //unbox, increment, box it back.

        Integer a = 1000;
        Integer b = 1000;
        if(a == b){ //always use EQUALS with objects
            System.out.println("a==b"); //probably not executes (only tests obj have identical memory location)
        }
        //The autoboxing specification requires that boolean, byte, char <= 127,
        //short, and int between -128 and 127 are wrapped into fixed objects. For
        //example, if a and b had been initialized with 100 in the preceding example,
        //then the comparison would have had to succeed.

        Integer i = null; // this class also immutable

        //if you mix Integer and Double types in a conditional expression, then
        //the Integer value is unboxed, promoted to double, and boxed into a Double:
        i = 10;
        Double d = 2.2;
        System.out.println(true ? i : d); // i converted to Double

        int x = Integer.parseInt("153");

        System.out.println(Integer.toString(5, 2)); //represent int into special num system (binary, octal, ..)

    }
}
