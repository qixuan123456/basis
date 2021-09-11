package day05;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
     public  static  int WIDTH = 512;
     public  static  int HEIGHT = 768;
     MyPanel myPanel;
    public MyFrame(){
        super("小程序");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dim.width-WIDTH)/2,0,WIDTH,HEIGHT);
        setLayout(null);

        this.myPanel= new MyPanel();
        this.myPanel.setBounds(0,0,512,768);
        this.add(myPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
