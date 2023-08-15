package com.justbelieveinmyself.javalang.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer(1000, new TimePrinter());
//        Timer timer = new Timer(1000, event -> {
//            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
//            Toolkit.getDefaultToolkit().beep();
//        });
        timer.start();
        JOptionPane.showConfirmDialog(null, "Quit program?");
        System.exit(0);
    }
}
class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
