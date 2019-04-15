package demo.wait4u.basic;

public class Joiner extends Thread {

	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
	}

	public void exec() {
		start();
	}

	@Override
	public void run() {
		try {
			System.out.println(getName() + " is waiting for " + sleeper.getName());
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}

		System.out.println(getName() + " join completed.");
	}

}
