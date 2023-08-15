package com.justbelieveinmyself.javalang.Interfaces;

import java.util.Arrays;
import java.util.Comparator;

public class CompareStringByLength {
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = new String("BAC");
        strings[1] = new String("AB");
        strings[2] = new String("ZZZZ");
       // Arrays.sort(strings, (String first, String second) -> second.length() - first.length());
        Arrays.sort(strings, new LengthComparator());
//        Arrays.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
//        Comparator<String> comparator = (first, second) -> second.length() - first.length();
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
class LengthComparator implements Comparator<String>{
    @Override
    public int compare(String first, String second) {
        return Integer.compare(second.length(), first.length());
//        return second.length() - first.length();

    }
}
