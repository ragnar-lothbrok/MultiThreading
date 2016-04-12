package com.company.threads.producerconsumer;

public class MainClass {

    public static void main(String[] args) {
        Data data = new Data("Whats up??");

        Consumer consumer = new Consumer(data);
        Thread consumerThread = new Thread(consumer, "Consumer Thread");
        consumerThread.start();

        Producer producer = new Producer(data);
        Thread producerThread = new Thread(producer, "Producer thread");
        producerThread.start();
    }

}
