package Swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class Swing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
           @Override
           public void run(){
                new MySwingApp();
           }
        });
    }
}
class MySwingApp implements ActionListener, ItemListener, ListSelectionListener {
    JFrame frame;
    JCheckBox jcbAlpha;
    JCheckBox jcbBeta;
    JCheckBox jcbGamma;
    JLabel changedLabel;
    JLabel currentSelectedLabel;
    JList<String> jListNames;
    JScrollPane scrollPane;
    JLabel jselectedInListLabel;
    JTextField jInputField;
    JLabel reverseInputLabel;
    String[] names = {"Ilya", "Dmitry", "Nikolay", "Vadim", "Eduard", "Nikita", "Julia", "John", "Alex"};
    public MySwingApp(){
        frame = new JFrame("Dota2");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200,200, 500, 400);
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Valve Corp");
        JButton button = new JButton("Play a game!");
        JButton defaultButton = new JButton("Test Default");
        defaultButton.setActionCommand("MyCommand");
        JLabel testLabel = new JLabel("Test Label");
        jInputField = new JTextField(10);
        jInputField.setActionCommand("Reverse");
        jInputField.addActionListener(this);
        jcbAlpha = new JCheckBox("Alpha");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");
        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);
        jselectedInListLabel = new JLabel("");
        jListNames = new JList<>(names);
        scrollPane = new JScrollPane(jListNames);
        reverseInputLabel = new JLabel("");
        jListNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListNames.addListSelectionListener(this);
        changedLabel = new JLabel("");
        currentSelectedLabel = new JLabel("");
        defaultButton.addActionListener(this); //использует свою же имплеминатацию
        button.setBounds(100, 100, 30, 15);
        button.addActionListener(new ActionListener() { //создает новый объект
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setTitle(e.getActionCommand());
            }
        });
        frame.add(jselectedInListLabel);
        frame.add(label, "North");
        frame.add(button);
        frame.add(defaultButton);
        frame.add(testLabel);
        frame.add(jcbAlpha);
        frame.add(jcbBeta);
        frame.add(jcbGamma);
        frame.add(changedLabel);
        frame.add(currentSelectedLabel);
        frame.add(scrollPane);
        frame.add(jInputField);
        frame.add(reverseInputLabel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Reverse")){
            String str = jInputField.getText();
            String reverse = "";
            for(int i = str.length()-1; i >= 0; i--){
                reverse += str.charAt(i);
            }
            reverseInputLabel.setText(reverse);
        }
        else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            frame.setTitle(ae.getActionCommand());
        }
    }
    @Override
    public void itemStateChanged(ItemEvent ie){
        JCheckBox currentCB = (JCheckBox) ie.getItem();
        if(currentCB.isSelected())
            changedLabel.setText(currentCB.getText() + " is Selected!");
        else
           changedLabel.setText(currentCB.getText() + " is Unselected");
        String str = "";
        if(jcbAlpha.isSelected())
            str += "Alpha ";
        if(jcbBeta.isSelected())
            str += "Beta ";
        if(jcbGamma.isSelected())
            str += "Gamma ";
        currentSelectedLabel.setText("Now is selected: " + str);
    }
    @Override
    public void valueChanged(ListSelectionEvent lse){
        int indexCurrent = jListNames.getSelectedIndex();
        if(indexCurrent != -1) {
            jselectedInListLabel.setText(names[indexCurrent]);
        }
        else
            jselectedInListLabel.setText("Choose name!");
    }
}