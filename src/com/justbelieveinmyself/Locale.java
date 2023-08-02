package com.justbelieveinmyself;

import java.util.Date;

import java.text.DateFormat;
import java.text.NumberFormat;

public class Locale
{
    public static void main(String[] args) {
        java.util.Locale localeUS = new java.util.Locale("en", "US");
        java.util.Locale localeDefault = java.util.Locale.getDefault();
        java.util.Locale localeGR = new java.util.Locale("de", "GR");
        System.out.println("DEFAULT LANG " + localeDefault);
        System.out.println("---------");
        System.out.println("ALL AVAAILABLE");
        java.util.Locale[] availableLocales = java.util.Locale.getAvailableLocales();
        for(java.util.Locale local : availableLocales){
            if(local.toString().startsWith("ru")) {
                System.out.println(local);
            }
        }
//-Duser.language=pt -Duser.region=BR
        System.out.println("CURRENCY IN DIFFERENT COUNTRIES:");
        System.out.println(NumberFormat.getCurrencyInstance(localeUS).format(100));
        System.out.println(NumberFormat.getCurrencyInstance(localeDefault).format(100));
        System.out.println(NumberFormat.getCurrencyInstance(localeGR).format(100));
        System.out.println("DATE IN DIFFERENT COUNTRIES:");
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, localeUS).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, localeDefault).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, localeGR).format(new Date()));
        System.out.println("TIME IN DIFFERENT COUNTRIES:");
        System.out.println(DateFormat.getTimeInstance(DateFormat.FULL, localeUS).format(new Date()));
        System.out.println(DateFormat.getTimeInstance(DateFormat.FULL, localeDefault).format(new Date()));
        System.out.println(DateFormat.getTimeInstance(DateFormat.FULL, localeGR).format(new Date()));
    }
}
