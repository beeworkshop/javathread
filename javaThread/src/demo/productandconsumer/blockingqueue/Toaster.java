package demo.productandconsumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random rand = new Random(55);

	public Toaster(ToastQueue tq) {
		toastQueue = tq;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MICROSECONDS.sleep(100 + rand.nextInt(500));
				System.out.println("Make toast");
				Toast t = new Toast(count++);
				System.out.println(t);
				System.out.println("Insert into queue");
				toastQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster off");
	}

}
