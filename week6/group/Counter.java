


public class Counter implements Runnable {
	private int num;

	public Counter(int start) {
		num = start;
	}	

	public void run() {
		while (num <= 100) {
			System.out.println(num);
			num += 2;
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				//
			}
		}
	}
}