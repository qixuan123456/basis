package com.qx.day17.thead;



public class main {

    public static void main(String[] args) {
        Piao piao = new Piao();
        for (int i = 0; i < 100; i++) {
            mythead mt = new mythead(piao);
            mt.start();
        }
    }

}

    class Piao {
      int nums;

        public Piao() {
         this.nums = 100;
     }

      public synchronized void Qiang() {
                nums=nums-1;
                System.out.println(this.nums);

        }
     }

    class mythead extends Thread {
         Piao piao;

        public mythead(Piao piao) {
         this.piao = piao;
     }

         @Override
        public void run() {
          piao.Qiang();
        }
    }
