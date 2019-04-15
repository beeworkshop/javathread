package demo.exception;

public class ExeptionThread implements Runnable {

	@Override
	public void run() {
		// 不能从线程中捕捉异常。在客户端使用try-catch块也捕获不到线程触发的异常。
		throw new RuntimeException("ExeptionThread抛出的异常");
	}

}
