package com.justbelieveinmyself.javalang.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LocalInnerClass {
    public static void main(String[] args) {
        var clock = new TalkingClockLocal(1000, true);
        clock.start(true);
        JOptionPane.showConfirmDialog(null, "Clock working?");
        System.exit(0);
    }
}
class TalkingClockLocal {
    private boolean beep = false;
    private int interval = 0;
    public TalkingClockLocal(int interval, boolean beep){
        this.beep = beep;
        this.interval = interval;
    }
    public void start(boolean useless){
        class TimePrinter implements ActionListener{
            String name = "b";
            public static int age =3;
            @Override
            public void actionPerformed(ActionEvent event){
                //useless =false; cannot (needs to final or effectively final)
                System.out.println("The time is " + new Date());
                if(TalkingClockLocal.this.beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        Timer timer = new Timer(interval, new TimePrinter());
        timer.start();
    }

}