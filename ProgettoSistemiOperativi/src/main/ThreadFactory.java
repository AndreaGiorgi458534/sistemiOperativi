package main;

import java.awt.image.BufferedImage;

public class ThreadFactory {
	private BufferedImage image;
	private int[] rowPixels;
	private RowThread rowThreads[];
	
	
	public ThreadFactory(BufferedImage image) {
		this.image = image;
		rowThreads = new RowThread[image.getHeight()];	//creazione del numero di istanze di RowThread
	}
	
	public void start() {
		for(int i = 0; i < 3; i++) {
			rowThreads[i] = new RowThread(image.getRGB(0, i, image.getWidth(), 1, null, 0, image.getWidth()));
			rowThreads[i].run();
		}
	}
}
