package day06;

import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel myPanel;

    public MyFrame()
    {
        super("闹钟");
        this.setBounds(600,200,620,620);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.myPanel = new MyPanel();
        this.myPanel.setBounds(0,0,620,620);
        this.setContentPane(this.myPanel);
        this.setVisible(true);
    }
}
