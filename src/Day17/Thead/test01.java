package Day17.Thead;

public class test01 {
    public static void main(String[] args) {
        myThread t = new myThread();
        t.start();
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"---->i");
        }
    }
}

class myThread extends Thread{

    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"---->i");
        }
    }
}