package com.justbelieveinmyself;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class Date {
    public static void main(String[] args) {
        LocalDate localDateNow = LocalDate.now();
        System.out.println(localDateNow.getMonth());
        LocalDate dateOf = LocalDate.of(2004, 05, 11);
        System.out.println("The day of week of my birthday: " + dateOf.getDayOfWeek());
        Stream<LocalDate> b = dateOf.datesUntil(localDateNow);
        System.out.println("How long do i live in days: " + b.count());

        LocalDate birthdayEduard = LocalDate.of(1996, 2, 16);
        System.out.println("My Bro day of week of birthday: " + birthdayEduard.getDayOfWeek() ); //accessor method
        birthdayEduard.plusDays(1); // doesnt mutate, need new variable (not mutator)

        java.util.Date date = new java.util.Date();
        System.out.println(date); // all methods are deprecated

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2004, 4,11);
        gregorianCalendar.add(Calendar.HOUR, 1); // is mutator method, will change date
        System.out.println();
        int day = gregorianCalendar.get(Calendar.DATE);  //accessor method
        System.out.println(day);

        System.out.println("------------------------------");
        System.out.println("CALENDAR");
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        int today = localDate.getDayOfMonth();

        localDate = localDate.minusDays(today-1);
        System.out.println(localDate.getDayOfMonth());
        DayOfWeek weekday = localDate.getDayOfWeek();
        int value = weekday.getValue(); // 1 - Monday, ... , 7 - Sunday
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i = 1; i < value; i++)
        {
            System.out.print("    ");
        }
        while(localDate.getMonthValue() == month){
            System.out.printf("%3d",localDate.getDayOfMonth());
            if(localDate.getDayOfMonth() == today){
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
            localDate = localDate.plusDays(1);
            if(localDate.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
        if(localDate.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }


    }
}
