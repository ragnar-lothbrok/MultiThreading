package com.company.threads.evenodd.approach1;

public class EvenOddGenerator implements Runnable {

    static volatile boolean isOdd = true;
    static Object lock = new Object();

    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0 && Thread.currentThread().getName().equals("Even")) {
                synchronized (lock) {
                    while (isOdd) {
                        try {
                            lock.wait();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    isOdd = true;
                    lock.notify();
                }
            }
            if (i % 2 != 0 && Thread.currentThread().getName().equals("Odd")) {
                synchronized (lock) {
                    while (!isOdd) {
                        try {
                            lock.wait();
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    isOdd = false;
                    lock.notify();
                }
            }
        }
    }

}
