package demo.exception;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");

		// 线程的私人订制（对于使用Executors来管理线程的情况。但只能定制Thread已有的内容，不能新增特性。）
		Thread t = new Thread(r);
		System.out.println("对Executors管理的线程进行定制。就在这里定制。");
		System.out.println("created " + t);

		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

		return t;
	}

}
