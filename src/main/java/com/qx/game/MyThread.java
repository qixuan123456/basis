package com.qx.game;



public class MyThread extends Thread {

    MyPanel myPanel;
    public MyThread(MyPanel myPanel)
    {
        this.myPanel = myPanel;
    }

    @Override
    public void run() {
        while(true)
        {
            this.myPanel.repaint();
            try {
                this.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
