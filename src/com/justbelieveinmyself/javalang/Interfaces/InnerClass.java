package com.justbelieveinmyself.javalang.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClass {
    public static void main(String[] args) {
        var clock = new TalkingClock(1000, true);
        clock.start();
        JOptionPane.showConfirmDialog(null, "Clock working?");
        System.exit(0);
    }
}
class TalkingClock {
    private boolean beep = false;
    private int interval = 0;
    public TalkingClock(int interval, boolean beep){
        this.beep = beep;
        this.interval = interval;
    }
    public void start(){
        Timer timer = new Timer(interval, new TimePrinter());
        timer.start();
    }
    private class TimePrinter implements ActionListener{
        String name = "b";
        public static int age =3;
        @Override
        public void actionPerformed(ActionEvent event){
            System.out.println("The time is " + new Date());
            if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}