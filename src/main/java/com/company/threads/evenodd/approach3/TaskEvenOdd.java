package com.company.threads.evenodd.approach3;

public class TaskEvenOdd implements Runnable {
    private int max;
    private PrintEvenOdd print;
    private boolean isEvenNumber;

    TaskEvenOdd(PrintEvenOdd print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    public void run() {

        int number = isEvenNumber == true ? 2 : 1;
        while (number <= max) {

            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }

    }
}
