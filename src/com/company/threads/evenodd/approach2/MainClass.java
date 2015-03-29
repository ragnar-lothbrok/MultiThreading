package com.company.threads.evenodd.approach2;

public class MainClass {

    public static void main(String[] args) {

        EvenGenerator t1 = new EvenGenerator();
        OddGenerator t2 = new OddGenerator();

        Thread even = new Thread(t1, "Even thread");
        Thread odd = new Thread(t2, "odd Thread");
        odd.start();
        even.start();

    }

}
