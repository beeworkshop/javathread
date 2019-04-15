package demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 6; i++) {
			exec.execute(new LiftOff());
		}
		// 防止新任务被提交给Executors
		// 程序将在Executors中的所有任务完成之后尽快退出
		exec.shutdown();
	}

}
