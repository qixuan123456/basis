package day06;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Date;

/**
 * @author xuan
 */
public class Alarm extends Thread {

    String S = "11:50";
    double s;
    double m;
    double h;
    String musicLocation = "src\\Day06\\fenkai.wav";

    public Alarm() {

    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            s = date.getSeconds();
            m = date.getMinutes();
            h = date.getHours();
            if (h != 9 && m != 8 && s != 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
        playMusic(musicLocation);
        System.out.println("已播放");

    }

    void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
