package com.justbelieveinmyself.javalang.Enumeration;

public class Main {
    public static void main(String[] args) {
        Size sizeSmall = Size.SMALL;
        System.out.println("My sizeSmall: " + sizeSmall.toString());

        Size s = Size.valueOf("SMALL");
//        Size s1 = Enum.valueOf(Size.class, "SMALL");

        Size[] allSizes = Size.values();

        int position = sizeSmall.ordinal();
        System.out.println("Position of " + sizeSmall.getAbbreviation() + " is " + position);

    }
}
