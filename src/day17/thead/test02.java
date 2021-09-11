package day17.thead;

public class test02 {
    public static void main(String[] args) {
        Thread t=new Thread(new myRunnable());
        t.start();
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}

class myRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}
