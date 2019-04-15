package demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecuteor {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}

		// 防止新任务被提交给Executors
		// 程序将在Executors中的所有任务完成之后尽快退出
		exec.shutdown();
	}

}
