package com.company.threads.evenodd.approach2;

public class EvenGenerator extends CommonGenerator {

    public void run() {
        for (int i = 0; i <= 10; i = i + 2) {
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
    }
}
