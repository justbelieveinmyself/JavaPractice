package com.justbelieveinmyself;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class UsingResouresBundles {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale defLocale = Locale.getDefault();
        Locale enLocale = new Locale("en");
        Locale engLocale = Locale.ENGLISH;
        //ResourceBundle resourceBundle = ResourceBundle.getBundle("Localization/resourses", enLocale); //from properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Localization.resourses", engLocale); //from classes
        String somevalue = resourceBundle.getString("somevalue");
        String encodeWithUTF = new String (somevalue.getBytes ("ISO-8859-1"),"UTF-8");
        String encodeWithUTF1 = new String (somevalue.getBytes ("ISO-8859-1"),"windows-1251");
        String out = new String(somevalue.getBytes("UTF-8"), "ISO-8859-1");
        System.out.println(out);
        System.out.println(encodeWithUTF);
        System.out.println(encodeWithUTF1);
        System.out.println(somevalue);
    }
}
