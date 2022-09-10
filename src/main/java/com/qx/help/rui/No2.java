package com.qx.help.rui;

/**
 * @author xuan
 * @date 2022/9/1 21:55
 */
public class No2 {

    public String a = "abcdefg";
    public String b = "1234567";

    public static void main(String[] args) throws InterruptedException {
        new No2().synchronizedTest();
    }
    public void synchronizedTest() throws InterruptedException {
        Object lock = new Object();
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        new Thread(() -> {
            for (int i = 0; i < aArr.length; i++) {
                printSynchronized(aArr, 0, i, lock);
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < aArr.length; i++) {
                printSynchronized(bArr, 1, i, lock);
            }

        }, "t2").start();
    }

    private volatile Integer status = 0;

    private void printSynchronized(char[] arr, int curStatus, int index, Object lock) {

        synchronized (lock) {

            while (curStatus != status) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(arr[index]);
            if (status == 2) {
                status = 0;
            } else {
                status++;
            }
            lock.notifyAll();
        }
    }

}
