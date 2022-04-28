package com.qx.day07;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Mypanel extends JPanel {

    List<String> arraylist = new JArrayList<>();
    public Mypanel()

    {
        this.setLayout(null);
        this.setBounds(0,0,500,500);
        JLabel jLabel = new JLabel("学生姓名");
        jLabel.setBounds(50,10,80,30);
        this.add(jLabel);

        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(150,10,100,30);
        this.add(jTextField);

        JTextArea jTextArea = new JTextArea(100,100);
        jTextArea.setBounds(10,150,200,200);
        this.add(jTextArea);
        JButton jButton1 = new JButton("添加学生");
        jButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.requestFocusInWindow();
                jTextField.selectAll();
                String text = jTextField.getText();
                System.out.println(text);
                if(text.isEmpty())
                {
                    return;
                }
                arraylist.add(text);
                replace(jTextArea);
            }
        });
        jButton1.setBounds(300,10,100,50);
        this.add(jButton1);

    }

    public void replace(JTextArea jTextArea)
    {
       jTextArea.setText(arraylist.toString());
    }
}
