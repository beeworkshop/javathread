package demo.wait4u.executors;

import java.util.concurrent.ThreadFactory;

public class UserThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		UserRunnable ur = (UserRunnable) r;
		ur.setSelf(t);
		return t;
	}

}

/*
 * Exception in thread "main" java.lang.ClassCastException:
 * java.util.concurrent.ThreadPoolExecutor$Worker cannot be cast to
 * demo.wait4u.executors.UserRunnable at
 * demo.wait4u.executors.UserThreadFactory.newThread(UserThreadFactory.java:10)
 * at
 * java.util.concurrent.ThreadPoolExecutor$Worker.<init>(ThreadPoolExecutor.java
 * :619) at
 * java.util.concurrent.ThreadPoolExecutor.addWorker(ThreadPoolExecutor.java:
 * 932) at
 * java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1378)
 * at demo.wait4u.executors.Joining.main(Joining.java:12)
 * 
 */
