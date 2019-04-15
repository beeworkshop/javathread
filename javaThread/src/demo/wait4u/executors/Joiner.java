package demo.wait4u.executors;

/**
 * 
 * @author beeworkshop
 * 
 *         让实现Runnable接口的类携带自己的Thread类型引用
 */
public class Joiner implements UserRunnable {

	private Sleeper sleeper;
	private Thread self;
	private String name;

	public Joiner(Sleeper sleeper, String name) {
		this.sleeper = sleeper;
		this.name = name;
	}

	@Override
	public void setSelf(Thread self) {
		this.self = self;
	}

	@Override
	public Thread getSelf() {
		return self;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is waiting for " + sleeper.getName());
			sleeper.getSelf().join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}

		System.out.println(name + " join completed.");

	}

}
