package com.company.threads.producerconsumer;

import java.util.Date;

public class Producer implements Runnable {
    Data data;

    public Producer(Data data) {
        this.data = data;
    }

    public void run() {
        System.out.println("Proucer is sleeping for 3 seconds at " + new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (data) {
            data.setMessage("Producer took a nap for 3 seconds");
            System.out.println("Producer is notifying consumer thread to wake up at " + new Date());
            data.notify();
        }
    }

}
