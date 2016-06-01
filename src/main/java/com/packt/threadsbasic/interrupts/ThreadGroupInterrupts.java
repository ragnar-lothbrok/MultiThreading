package com.packt.threadsbasic.interrupts;

public class ThreadGroupInterrupts {

	public static void main(String[] args) {

		ThreadGroup threadGroup = new ThreadGroup("test-interrupts");
		for (int i = 0; i < 5; i++) {
			Thread testThread1 = new Thread(threadGroup, new TestThread());
			Thread testThread2 = new Thread(threadGroup, new TestThread());
			Thread testThread3 = new Thread(threadGroup, new TestThread());
			Thread testThread4 = new Thread(threadGroup, new TestThread());

			testThread1.start();
			testThread2.start();
			testThread3.start();
			testThread4.start();
			
			//threadGroup.interrupt();
			testThread4.interrupt();
			threadGroup.list();

		}

	}

	static class TestThread implements Runnable {
		public void run() {
			while (true) {
				System.out.println(">>>" + Thread.currentThread().getName());
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Thread intrrupted : >>>");
					Thread.currentThread().getThreadGroup().interrupt();
					return;
				}
			}
		}

	}

}
