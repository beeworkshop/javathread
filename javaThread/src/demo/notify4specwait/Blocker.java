package demo.notify4specwait;

public class Blocker {
	public synchronized void waitingCall() {
		try {
			while (!Thread.interrupted()) {
				wait();
				System.out.println(Thread.currentThread() + " ");
			}
		} catch (InterruptedException e) {
			System.out.println("OK to exit this way");
		}
	}

	public synchronized void prod() {
		notify();
	}

	public synchronized void prodAll() {
		notifyAll();
	}
}
