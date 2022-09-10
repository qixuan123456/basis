package com.qx.game;

import java.awt.*;

public class Hero {
    int x;
    int y;

    Image HeroImage;
    public Hero(){
        HeroImage = Toolkit.getDefaultToolkit().getImage("com/qx/Day05/image/hero1.png");
        x = 100;
        y = 100;

    }
}
