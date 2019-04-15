package demo.wait4u.basic;

public class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
	}

	public void exec() {
		start();
	}

	@Override
	public void run() {
		try {
			System.out.println(getName() + " is sleeping");
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. isInterrupted(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}
