package com.packt.threadsbasic.interrupts;

public class Calculator implements Runnable {

	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	public void run() {
		for (int i = 1; i <= 1000000000; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Thread.currentThread().isInterrupted()){
				System.out.println("lol");
				return;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = null;
		for (int i = 1; i <= 1; i++) {
			Calculator calculator = new Calculator(i);
			 thread = new Thread(calculator);
			thread.start();
		}
		
		Thread.currentThread().sleep(2000);
		thread.interrupt();

	}

}
