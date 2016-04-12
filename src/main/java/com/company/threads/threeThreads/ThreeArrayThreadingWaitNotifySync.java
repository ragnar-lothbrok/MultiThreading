package com.company.threads.threeThreads;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeArrayThreadingWaitNotifySync {

	final static Object lock = new Object();

	static int arr1[] = { 1, 4, 7, 10, 13, 16, 19 };
	static int arr2[] = { 2, 5, 8, 11, 14, 17, 20 };
	static int arr3[] = { 3, 6, 9, 12, 15, 18, 21 };

	static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {

		Thread ft = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < arr1.length; i++) {
					synchronized (lock) {
						while (atomicInteger.get() != 1) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println(arr1[i]);
						atomicInteger.set(2);
						lock.notifyAll();
					}
				}
			}
		});

		Thread st = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < arr2.length; i++) {
					synchronized (lock) {
						while (atomicInteger.get() != 2) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println(arr2[i]);
						atomicInteger.set(3);
						lock.notifyAll();
					}
				}
			}
		});
		Thread tt = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < arr3.length; i++) {
					synchronized (lock) {
						while (atomicInteger.get() != 3) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println(arr3[i]);
						atomicInteger.set(1);
						lock.notifyAll();
					}
				}
			}
		});

		tt.start();
		st.start();
		ft.start();

	}
}
