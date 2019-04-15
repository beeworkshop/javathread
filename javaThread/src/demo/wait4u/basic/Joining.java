package demo.wait4u.basic;

public class Joining {

	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500), grumpy = new Sleeper("Grumpy", 1500);
		Joiner dopey = new Joiner("Dopey", sleepy), doc = new Joiner("Doc", grumpy);

		sleepy.exec();
		grumpy.exec();
		dopey.exec();
		doc.exec();

		// interrupt()会清除中断标记，此时调用isInterrupted()的结果为false
		grumpy.interrupt();
	}

}
