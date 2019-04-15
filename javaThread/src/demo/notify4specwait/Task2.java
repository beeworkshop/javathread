package demo.notify4specwait;

public class Task2 implements Runnable {
	// A separate Blocker object:
	static Blocker blocker = new Blocker();

	@Override
	public void run() {
		blocker.waitingCall();
	}

}
