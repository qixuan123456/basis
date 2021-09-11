package day20.duoxiancheng;

public class SellTicket {
    public static void main(String[] args) {

        sell s=new sell(12);
        Thread thread1 = new Thread(s);
        thread1.start();
    }




}
class sell implements Runnable{
     private int total = 10000;
     private int num = 0;
     public sell(int i){
         this.num = i;
     }
    @Override
  synchronized public void run() {
        if(total >=0 && num>0 && total - num >=0){
            total -= num;
            System.out.println("还剩"+total+"张票");
        }
        else{
            System.out.println("购票失败");
        }
    }
}
class MyThread extends Thread{
     public MyThread(){

     }

    @Override
    public void run() {

    }
}