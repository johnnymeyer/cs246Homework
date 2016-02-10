

public class HeartBeat implements Runnable {

	private boolean flag = true;

	public void run() {
		while (flag) {
			System.out.println("running...");
			
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				//
			}
		}
	}

	public void setFlag(boolean f) {
		flag = f;
	}
}