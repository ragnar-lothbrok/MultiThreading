package com.company.threads.evenodd.approach1;

import com.company.threads.evenodd.approach1.EvenOddGenerator;

public class MainClass {

    public static void main(String[] args) {
        EvenOddGenerator t1 = new EvenOddGenerator();
        EvenOddGenerator t2 = new EvenOddGenerator();

        Thread odd = new Thread(t1, "Odd");
        Thread even = new Thread(t2, "Even");
        odd.start();
        even.start();
    }

}
