package com.demo.datastruct;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CycABC {
	public static void main(String[] args) {
//		AB t = new AB();
//		new Thread(t, "A").start();
//		new Thread(t, "B").start();
		
		ABC t= new ABC();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}

}

/*
 * 两线程轮流打印AB各10次
 */
class AB implements Runnable {

	int sum = 40;

	@Override
	public synchronized void run() {
		synchronized (this) {
			while (sum-- > 0) {
				if (Thread.currentThread().getName().equals("A")) {
					this.notify();
					System.out.println("A" + sum);
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					this.notify();
					System.out.println("B" + sum);
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			this.notify();
		}
	}

}

/*
 * 三线程轮流打印ABC各10次
 */
class ABC implements Runnable{

	public static int cnt = 0;
	public static final int COUNT = 60;
	final Lock lock = new ReentrantLock();
	@Override
	public void run() {
		while (true) {
			lock.lock();
			if (cnt >= COUNT) {
				lock.unlock();
				return;
			}
			if (cnt % 3 == 0)
				System.out.println("A");
			else if(cnt % 3 == 1)
				System.out.println("B");
			else if(cnt % 3 == 2)
				System.out.println("C");
			cnt++;
			lock.unlock();
		}

	}
}