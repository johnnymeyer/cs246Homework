

public class ThreadRunner {

	public static void main(String[] args) {
		System.out.println("here1");

		Counter odd = new Counter(1);
		Counter even = new Counter(0);
		HeartBeat beat = new HeartBeat();

		Thread threadOdd = new Thread(odd);
		Thread threadEven = new Thread(even);
		Thread threadBeat = new Thread(beat);

		threadBeat.start();
		threadOdd.start();
		threadEven.start();

		try {
			threadOdd.join();
			threadEven.join();
		}
		catch (InterruptedException e) {
			// 	
		}
		beat.setFlag(false);

		System.out.println("All finished");
	}

}
