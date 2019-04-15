package demo.cooperation.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	private boolean waxOn = false;

	public void waxed() {
		lock.lock();
		try {
			System.out.println("Ready to buff");
			waxOn = true;
			condition.signalAll();

		} finally {
			lock.unlock();
		}
	}

	public void buffed() {
		lock.lock();
		try {
			System.out.println("Ready for another coat of wax");
			waxOn = false;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void waitForWaxing() throws InterruptedException {
		lock.lock();
		try {
			while (waxOn == false) {
				condition.await();
			}
		} finally {
			lock.unlock();
		}
	}

	public void waitForBuffing() throws InterruptedException {
		lock.lock();
		try {
			while (waxOn == true) {
				condition.await();
			}
		} finally {
			lock.unlock();
		}
	}
}
