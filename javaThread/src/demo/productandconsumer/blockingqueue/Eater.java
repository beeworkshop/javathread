package demo.productandconsumer.blockingqueue;

/**
 * 
 * @author beeworkshop
 * 
 *         Consume the toast
 *
 */
public class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int counter = 0;

	public Eater(ToastQueue finished) {
		finishedQueue = finished;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("Blocks until next piece of toast is available");
				Toast t = finishedQueue.take();
				System.out.println("Verify that the toast is coming in order and that all pieces are getting jammed.");
				if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
					System.out.println(">>>>>>>>>> Error: " + t);
					System.exit(1);
				} else {
					System.out.println("Chomp! " + t);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater off");
	}

}
