package com.company.threads.evenodd.approach3;

public class MainClass {
    public static void main(String[] args) {
        PrintEvenOdd print = new PrintEvenOdd();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true));
        t1.start();
        t2.start();
    }
}
