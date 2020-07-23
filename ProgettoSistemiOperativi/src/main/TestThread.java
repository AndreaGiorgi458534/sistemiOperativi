package main;

import java.util.Random;

public class TestThread extends Thread {

	@Override
	public void run() {
		Random r = new Random();
		try {
			sleep(r.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread : " + Thread.currentThread());
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	
	
}
