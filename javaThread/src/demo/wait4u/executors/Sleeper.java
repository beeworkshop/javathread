package demo.wait4u.executors;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author beeworkshop
 * 
 *         让实现Runnable接口的类携带自己的Thread类型引用
 */
public class Sleeper implements UserRunnable {
	private int duration;
	private Thread self;
	private String name;

	public Sleeper(int duration, String name) {
		this.duration = duration;
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
		if (self == null) {
			return;
		}

		try {
			System.out.println(name + " is sleeping");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(name + " was interrupted. isInterrupted(): " + self.isInterrupted());
			return;
		}
		System.out.println(name + " has awakened");
	}

}
