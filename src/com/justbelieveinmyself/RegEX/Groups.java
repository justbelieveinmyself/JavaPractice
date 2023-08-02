package com.justbelieveinmyself.RegEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("Set(?:Value)?"); //() backreferences  ?: don't use backrefereces
//        Pattern p = Pattern.compile("Set(Value)?"); //() backreferences. this works slower
//        Matcher m = p.matcher("Set or SetValue");
//        while(m.find()) {
//            System.out.print(m.start() + " " + m.group() + " ");
//        }
        //System.out.println("");

//        Pattern p2 = Pattern.compile("EditPad (Lite|Pro)");
//        Matcher m2 = p2.matcher("EditPad Lite version");
//        while(m2.find()) {
//            System.out.print(m2.start() + " " + m2.group() + " ");
//        }
//        System.out.println("");
//
        //System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$1 version")); // \\1
        //we find all the matches in text which suits the regex and replace it with 1st group with "version"
        //System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$0 version"));//all regex
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\U1 version").toUpperCase());//upercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$1 version").toUpperCase());//upercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\L1 version").toLowerCase());//lovercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\F1 version"));//FirstLetter uppercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\I1 version"));//each letter upercase
//
//        Pattern p3 = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>");
//        Matcher m3 = p3.matcher("This is a <EM>first</EM> <HD> fasf321 </HD>test");
//        while(m3.find()) {
//            System.out.print(m3.start() + " " + m3.group() + " ");
//        }
//        System.out.println("");
//
//        Pattern p4 = Pattern.compile("([a-c])x\\1x\\1");//[a-c]xaxa
//        Matcher m4 = p4.matcher("axaxa");
//        while(m4.find()) {
//            System.out.print(m4.start() + " " + m4.group() + " ");
//        }
//        System.out.println("");
////
//        Pattern p42 = Pattern.compile("([a-c]\\1)");//error
//        Matcher m42 = p42.matcher("axaxa");
//        while(m42.find()) {
//            System.out.print(m42.start() + " " + m42.group() + " ");
//        }
//        System.out.println("");
////
//
//        Pattern p5 = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>");
//        Matcher m5 = p5.matcher("Testing <B da><I dadasdd>bold italic</I></B> text");
//        while(m5.find()) {
//            System.out.print(m5.start() + " " + m5.group() + " ");
//        }
//        System.out.println("");
//
//        Pattern p6 = Pattern.compile("([abc]+)");
//        Pattern p6 = Pattern.compile("([abc])+"); //not equal
//        Matcher m6 = p6.matcher("cab"); // this, see next example
//        while(m6.find()) {
//            System.out.print(m6.start() + " " + m6.group() + " ");
//        }
//        System.out.println("");
//
////        Pattern p7 = Pattern.compile("([abc]+)=\\1"); //1
//        Pattern p7 = Pattern.compile("([abc])+=\\1"); //2
////        Matcher m7 = p7.matcher("cab=cab"); //1
//        Matcher m7 = p7.matcher("cab=b"); //2
//        while(m7.find()) {
//            System.out.print(m7.start() + " " + m7.group() + " ");
//        }
//        System.out.println("");
////
//        System.out.println("the the".replaceAll("\\b(\\w+)\\s+\\1\\b", "$1"));
//
//        Pattern p8 = Pattern.compile("[(a)b\1]");//literally
//        Matcher m8 = p8.matcher("abc()\\1");
//        while(m8.find()) {
//            System.out.print(m8.start() + " " + m8.group() + " ");
//        }
//        System.out.println("");
    }
}
