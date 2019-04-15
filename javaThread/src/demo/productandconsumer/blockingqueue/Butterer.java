package demo.productandconsumer.blockingqueue;

/**
 * 
 * @author beeworkshop
 *
 *         Apply butter to toast
 */
public class Butterer implements Runnable {
	private ToastQueue dryQueue, butteredQueue;

	public Butterer(ToastQueue dry, ToastQueue buttered) {
		dryQueue = dry;
		butteredQueue = buttered;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Blocks until next piece of toast is available");
				Toast t = dryQueue.take();
				t.butter();
				System.out.println(t);
				butteredQueue.put(t);
			}
		} catch (InterruptedException e) {
			System.out.println("Butterer off");
		}

	}

}
