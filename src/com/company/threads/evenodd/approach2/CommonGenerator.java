package com.company.threads.evenodd.approach2;

public abstract class CommonGenerator implements Runnable {

    protected static volatile boolean isOdd;
    
    protected static Object lock = new Object();
}
