package Day05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyPanel extends JPanel {

    public Image bgimage;
    int m=0;
    int timer = 0;
    MyThread myThread;
    Hero hero;
    public MyPanel()
    {
        this.hero = new Hero();
        this.bgimage = Toolkit.getDefaultToolkit().getImage("./src/Day05/image/background.png");
        this.myThread = new MyThread(this);
        this.myThread.start();

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                hero.x=e.getX()-48;
                hero.y=e.getY()-62;
                repaint();
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgimage,0,m-this.bgimage.getHeight(this),this.bgimage.getWidth(this),this.bgimage.getHeight(this),null);
        g.drawImage(bgimage,0,m,this.bgimage.getWidth(this),this.bgimage.getHeight(this),null);
        g.drawImage(hero.HeroImage,hero.x,hero.y,null);
        timer++;
        if(timer==10000);
        timer= 0;
        if(timer%10==0)
        {
            m++;
            if(m>=this.bgimage.getHeight(this))
                m=0;
        }
    }
}
