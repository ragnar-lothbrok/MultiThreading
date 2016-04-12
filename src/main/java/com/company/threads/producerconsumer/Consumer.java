package com.company.threads.producerconsumer;

import java.util.Date;

public class Consumer implements Runnable {

    Data data;

    public Consumer(Data data) {
        this.data = data;
    }

    public void run() {
        synchronized (data) {
            try {
                System.out.println("Consumer is waiting for the notifier at " + new Date());
                data.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Consumer is done waiting at " + new Date());
        System.out.println("Consumer got the data: " + data.getMessage());

    }

}
