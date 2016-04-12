package com.company.threads.threeThreads;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeArrayThreadingSynchronized {

	final static Object lock = new Object();

	static int arr1[] = { 1, 4, 7, 10, 13, 16, 19 };
	static int arr2[] = { 2, 5, 8, 11, 14, 17, 20 };
	static int arr3[] = { 3, 6, 9, 12, 15, 18, 21 };

	static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {

		Thread ft = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < arr1.length; i++) {
					while (atomicInteger.get() != 1) {
						continue;
					}
					synchronized (lock) {
						System.out.println(arr1[i]);
						atomicInteger.set(2);
					}
				}
			}
		});

		Thread st = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < arr2.length; i++) {
					while (atomicInteger.get() != 2) {
						continue;
					}
					synchronized (lock) {
						System.out.println(arr2[i]);
						atomicInteger.set(3);
					}
				}
			}
		});
		Thread tt = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < arr3.length; i++) {
					while (atomicInteger.get() != 3) {
						continue;
					}
					synchronized (lock) {
						System.out.println(arr3[i]);
						atomicInteger.set(1);
					}
				}
			}
		});

		tt.start();
		st.start();
		ft.start();

	}
}
