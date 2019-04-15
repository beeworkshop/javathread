package demo.threadpool;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	// Runnable接口是执行过程不返回值，而Callable接口是执行函数，要返回值
	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}

}
