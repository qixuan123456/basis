package Day06;

public class MyThread extends Thread{

    MyPanel myPanel;
    public MyThread(MyPanel myPanel)
    {
        this.myPanel=myPanel;
    }

    @Override
    public void run() {
        super.run();
        while(true)
        {
            this.myPanel.repaint();

        }
    }
}
