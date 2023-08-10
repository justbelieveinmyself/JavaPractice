package com.justbelieveinmyself;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumFormat {
    public static void main(String[] args) throws ParseException {
        Locale locale = new Locale("en", "us");
        Locale localeDef = new Locale("de", "GR");
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println(percent.format(0.15));
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        System.out.println(currency.format(1000));
        NumberFormat currencyDef = NumberFormat.getCurrencyInstance(localeDef);
        System.out.println(currencyDef.format(1000));

        //parse String to int
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.parse("100"));
    }
}
