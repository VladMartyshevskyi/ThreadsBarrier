import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DataProcessor implements Runnable {
	public static final CyclicBarrier gate = new CyclicBarrier(3);

	@Override
	public void run() {
		try {
			gate.await();
			process();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

	private void process() throws InterruptedException {
		System.out.println("Started processing | Thread: " + Thread.currentThread().getName());
		Thread.sleep(1000);
		System.out.println("Finished processing | Thread: " + Thread.currentThread().getName());
	}
}
