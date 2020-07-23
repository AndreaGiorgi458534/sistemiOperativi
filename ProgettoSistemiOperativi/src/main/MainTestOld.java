package main;

public class MainTestOld {

	public static void main(String[] args) throws InterruptedException {
	TestThread ts[] = new TestThread[10];	
		for (int i = 0; i < 10; i++) {
			ts[i] = new TestThread();
			ts[i].start();
			ts[i].join(); //aspetta che il thread abbia finito
		}
	}
}
