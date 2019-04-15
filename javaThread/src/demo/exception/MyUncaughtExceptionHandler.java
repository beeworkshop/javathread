package demo.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	// 为特定线程定制专门的异常处理器（只能定制已有的内容，不能定制没有的内容）
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + "\'s exception is caught: " + e);

	}

}
