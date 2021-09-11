package day17.theadtest;

public class test {
    public static void main(String[] args) {
    ShuZi shuZi = new ShuZi();
    Thread product = new Thread(new Product(shuZi));
    Thread customer = new Thread(new Customer(shuZi));
    product.setName("生产者线程----->");
    customer.setName("消费者线程----->");
    product.start();
    customer.start();
    }
}

class Product implements Runnable {
    ShuZi shuZi;
    int i=0;
    Product(ShuZi shuZi) {
        this.shuZi=shuZi;
    }

    @Override
    public void run() {
        while (i<10) {
            synchronized (shuZi){
                shuZi.a++;
                System.out.println(Thread.currentThread().getName()+shuZi.a);
            }
            try {
                shuZi.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}

class Customer implements Runnable {
    ShuZi shuZi;
    int i=0;
    Customer(ShuZi shuZi){
        this.shuZi =shuZi;
    }
    @Override
    public void run() {
        while (i<10) {
            synchronized (shuZi){
                shuZi.a++;
                System.out.println(Thread.currentThread().getName()+shuZi.a);
                shuZi.notify();
            }

            i++;

        }
    }
}


class ShuZi{
    int a=0;
}