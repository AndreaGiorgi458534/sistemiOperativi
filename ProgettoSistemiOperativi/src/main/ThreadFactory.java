package main;

import java.awt.image.BufferedImage;


public class ThreadFactory {
	private BufferedImage image;
	private int[] rowPixels;
	private RowThread rowThreads[];

	public ThreadFactory(BufferedImage image) {
		this.image = image;
		rowThreads = new RowThread[image.getHeight()]; // creazione del numero di istanze di RowThread
	}

	public void start() {
		// adesso lo fa per ogni riga
		for (int i = 0; i < image.getHeight(); i++) {
			rowThreads[i] = new RowThread(i, image.getRGB(0, i, image.getWidth(), 1, null, 0, image.getWidth()));
			rowThreads[i].start();
		}

		for (int i = 0; i < image.getHeight(); i++) {
			try {
				rowThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int maxSequence = rowThreads[0].getMaxSequence();
		int pixel = rowThreads[0].getMaxPixelValue();
		int rowNumber = 0;

		for (int i = 0; i < image.getHeight(); i++) {
			if (rowThreads[i].getMaxSequence() > maxSequence) {
				maxSequence = rowThreads[i].getMaxSequence();
				pixel = rowThreads[i].getMaxPixelValue();
				rowNumber = i;
			}
		}
		System.out.println("row: " + rowNumber + " pixel: " + pixel + " sequenza: " + maxSequence);
	}
}
