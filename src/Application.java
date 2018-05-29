
public class Application {

	public static void main(String[] args) throws Exception {
		DataProcessor dataProcessor = new DataProcessor();

		new Thread(dataProcessor).start();
		System.out.println("After creation first thread");

		Thread.sleep(500);

		new Thread(dataProcessor).start();
		System.out.println("After creation second thread");

		DataProcessor.gate.await(); // Start point
	}
}
