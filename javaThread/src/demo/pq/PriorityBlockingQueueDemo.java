package demo.pq;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		Random rand = new Random(44);

		ExecutorService exec = Executors.newCachedThreadPool();

		PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();

		exec.execute(new PrioritizedTaskProducer(queue, exec));
		exec.execute(new PrioritizedTaskConsumer(queue));
	}

}
