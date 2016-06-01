package com.packt.threadsbasic.interrupts;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	ThreadGroup threadGroup;

	public CustomThreadFactory(ThreadGroup threadGroup) {
		this.threadGroup = threadGroup;
	}

	public Thread newThread(Runnable r) {
		return new Thread(threadGroup, r);
	}

	public static void main(String[] args) {
		ThreadGroup tg1 = new ThreadGroup("thread-group");
		CustomThreadFactory ctf = new CustomThreadFactory(tg1);

		Runnable r = new Runnable() {

			public void run() {
				while (true) {
					System.out.println("lol : " + Thread.currentThread().getName());
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Thread intrrupted : >>>");
						// Thread.currentThread().getThreadGroup().interrupt();
						return;
					}
				}
			}
		};

		Thread t1 = ctf.newThread(r);
		Thread t2 = ctf.newThread(r);
		Thread t3 = ctf.newThread(r);
		Thread t4 = ctf.newThread(r);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		tg1.interrupt();
	}

}
