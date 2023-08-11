package com.justbelieveinmyself.javalang.Interfaces;

import java.util.Arrays;
import java.util.Comparator;

public class CompareStringByLength {
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = new String("BAC");
        strings[1] = new String("AB");
        strings[2] = new String("ZZZZ");
        Arrays.sort(strings, new LengthComparator());
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String first, String second) {
        return Integer.compare(second.length(), first.length());
//        return first.length() - second.length();
    }
}
