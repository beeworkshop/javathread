package demo.exception;

public class ExceptionThread2 implements Runnable {

	@Override
	public void run() {
		// 在实现Runnable接口的类中如何获得Thread类型的当前线程？
		Thread t = Thread.currentThread();

		System.out.println("run() by " + t);
		System.out.println("eh = " + t.getUncaughtExceptionHandler());

		throw new RuntimeException("ExceptionThread2抛出的异常");
	}

}
