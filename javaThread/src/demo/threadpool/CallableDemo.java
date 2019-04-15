package demo.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}

		for (Future<String> fs : results) {
			try {
				// get() blocks until completion
				// fs.isDone()可以判断任务是否已经完成，是否可以取返回值了
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}

}
