package demo.wait4u.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Joining {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new UserThreadFactory());

		Sleeper sleepy = new Sleeper(1500, "Sleepy"), grumpy = new Sleeper(1500, "Grumpy");
		exec.execute(sleepy); // 在Runnable接口实现类中注入其Thread类型引用
		exec.execute(grumpy); // 在Runnable接口实现类中注入其Thread类型引用

		Joiner dopey = new Joiner(sleepy, "Dopey"), doc = new Joiner(grumpy, "Doc");
		exec.execute(dopey); // 在Runnable接口实现类中注入其Thread类型引用
		exec.execute(doc); // 在Runnable接口实现类中注入其Thread类型引用

		// interrupt()会清除中断标记，此时调用isInterrupted()的结果为false
		grumpy.getSelf().interrupt();

		exec.shutdown();
	}

}
