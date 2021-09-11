package day06;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MyPanel extends JPanel {
    MyThread myThread;
    Alarm alarm;
    public static double PI = 3.1415926;
    double h;
    double m;
    double s;
    Graphics g;
    public MyPanel()
    {

        this.myThread = new MyThread(this);
        this.myThread.start();

        this.alarm = new Alarm();
        alarm.start();
        setBackground(Color.PINK);

    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Date date = new Date();
        s = date.getSeconds();
        m = date.getMinutes();
        h = date.getHours();

        Graphics2D g2 = (Graphics2D)g;
        g2.drawOval(60,60,500,500);


       // g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2.0f));
       for(int i=1;i<=12;i++)
       {
           g2.drawString(String.valueOf(i),305+(int)(220*Math.cos(i*PI/6-PI/2)),312+(int)(220*Math.sin(i*PI/6-PI/2)));
           g2.drawLine(310+(int)(230*Math.cos(i*PI/6-PI/2)),310+(int)(230*Math.sin(i*PI/6-PI/2)),310+(int)(250*Math.cos(i*PI/6-PI/2)),310+(int)(250*Math.sin(i*PI/6-PI/2)));
        }

       // g2.setColor(Color.BLACK);
        /** 设置宽度  画表针  **/
        Stroke stroke2=new BasicStroke(1.0f);
        g2.setStroke(stroke2);
        g2.drawLine(310,310,310+(int)(200*Math.cos(s/30*PI-PI/2)),310+(int)(200*Math.sin(s*PI/30-PI/2)));

        Stroke stroke=new BasicStroke(3.0f);
        g2.setStroke(stroke);
        g2.drawLine(310,310,310+(int)(150*Math.cos(m/30*PI-PI/2)),310+(int)(150*Math.sin(m*PI/30-PI/2)));

        Stroke stroke1=new BasicStroke(5.0f);
        g2.setStroke(stroke1);
        g2.drawLine(310,310,310+(int)(100*Math.cos(h/6*PI-PI/2)),310+(int)(100*Math.sin(h*PI/6-PI/2)));

        //System.out.println(Math.cos(s/180*PI));
       // System.out.println( h +"  " + m +"  "+  s);



    }
}
