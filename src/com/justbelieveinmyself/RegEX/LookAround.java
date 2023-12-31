package com.justbelieveinmyself.RegEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookAround {
    public static void main(String[] args) {
        //(?=(regex))
        //loockahead
//        Pattern p = Pattern.compile("q(?=u)");//(?=(regex))  - \\1
//        Pattern p = Pattern.compile("q(?!u)");
////        Matcher m = p.matcher("quqa");
//        Matcher m = p.matcher("Iraq");
//        while(m.find()) {
//            System.out.print(m.start() + " " + m.group() + " ");
//        }
//        System.out.println("");

//        //loogbehind
//        Pattern p2 = Pattern.compile("(?<!a)b");
//        Matcher m2 = p2.matcher("cb");
//        while(m2.find()) {
//            System.out.print(m2.start() + " " + m2.group() + " ");
//        }
//        System.out.println("");
//
//        //work that ends with s
////        Pattern p3 = Pattern.compile("\\b\\w+(?<!s)\\b");
////        Pattern p3 = Pattern.compile("\\b\\w+[^s]\\b");
//        Pattern p3 = Pattern.compile("\\b\\w*[^s\\W]\\b");
//        Matcher m3 = p3.matcher("John's");
//        while(m3.find()) {
//            System.out.print(m3.start() + " " + m3.group() + " ");
//        }
//        System.out.println("");

//        Pattern p4 = Pattern.compile("(?=(\\d+))\\w+\\1");
//        Matcher m4 = p4.matcher("131423xty12365");
////        Pattern p4 = Pattern.compile("(?=(a|b))c");
////        Matcher m4 = p4.matcher("ac");
//        while(m4.find()) {
//            System.out.print(m4.start() + " " + m4.group() + " ");
//        }
//        System.out.println("");


//---------------------------//---------------------------//---------------------------//---------------------------//---------------------------
            //word 6 letters and have a "cat"
            //cat\w{3}|\wcat\w{2}|\w{2}cat\w|\w{3}cat
            //1 b\w{6}\b
            //2 \b\w*cat\w*\b
            //(?=\b\w{6}\b)\b\w*cat\w*\b
            //(?=\b\w{6}\b)\w*cat\w*
            //(?=\b\w{6}\b)\w{0,3}cat\w*
            //\b(?=\w{6}\b)\w{0,3}cat\w*
            Pattern p = Pattern.compile("(?=\\b\\w{6}\\b)\\w*cat\\w*");
            Matcher m = p.matcher("wecate");
            while(m.find()) {
                System.out.print(m.start() + " " + m.group() + " ");
            }
            System.out.println("");

            //word 6-12 letter should have cat or dog or mouse
            Pattern p2 = Pattern.compile("\\b(?=\\w{6,12}\\b)\\w{0,9}(cat|dog|mouse)\\w*");
            Matcher m2 = p2.matcher("wecate");
            while(m2.find()) {
                System.out.print(m2.start() + " " + m2.group() + " ");
            }
            System.out.println("");


    }
}
