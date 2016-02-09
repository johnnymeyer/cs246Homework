class Dancer implements Runnable {
	
	int _myNumber;
	public Dancer(int number) {
		_myNumber = number;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		System.out.println("Dancer number " + _myNumber + " is dancing!");
		}
		catch (InterruptedException e) {
			// this will not happen happen
		}
	}
}


class ThreadTest {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10000; i++) {
			Dancer theDancer = new Dancer(i);
			Thread theThread = new Thread(theDancer);
			theThread.start();
			System.out.println("Started dancer " + i);
		}
		
		System.out.println("Done dancing!");
	}
}