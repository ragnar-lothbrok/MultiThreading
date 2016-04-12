package com.company.threads.evenodd.approach2;

public class OddGenerator extends CommonGenerator {

    public void run() {
        for (int i = 1; i <= 9; i=i+2) {
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
