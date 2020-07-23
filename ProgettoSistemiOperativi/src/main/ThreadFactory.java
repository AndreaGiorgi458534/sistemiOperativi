package main;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class ThreadFactory {
	private BufferedImage image;
	private int[] rowPixels;
	private RowThread rowThreads[];
	private Vector<Result> results;
	
	public ThreadFactory(BufferedImage image) {
		this.image = image;
		rowThreads = new RowThread[image.getHeight()];	//creazione del numero di istanze di RowThread
		results = new Vector<Result>();
	}
	
	public void start() {
		//adesso lo fa per ogni riga
		for(int i = 0; i < image.getHeight(); i++) {
			rowThreads[i] = new RowThread(i, 
										  image.getRGB(0, i, image.getWidth(), 1, null, 0, image.getWidth()),
										  results);
			rowThreads[i].run();
		}
	}
}
