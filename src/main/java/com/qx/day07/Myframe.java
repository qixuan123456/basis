package com.qx.day07;

import javax.swing.*;

public class Myframe extends JFrame {
    public Mypanel mypanel;
    public JLabel jLabel;
    public Myframe()
    {

        super("测试");

        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mypanel = new Mypanel();
        this.setContentPane(mypanel);




        this.setVisible(true);
    }
}
