package day02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test01 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String s =sdf.format(new Date());

        System.out.println(s);


        Timer timer = new Timer();
        timer.schedule(new Logtast(),new Date(),1000);
    }
}
class Logtast extends TimerTask{

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String s =sdf.format(new Date());
        System.out.println(s);
    }
}