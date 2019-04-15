package demo.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingDefaultHandler {

	public static void main(String[] args) {
		// 仅用于设置统一的默认兜底的异常处理器
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExeptionThread());

		// 别忘了这个，不然就停不下来了
		exec.shutdown();
	}

}
