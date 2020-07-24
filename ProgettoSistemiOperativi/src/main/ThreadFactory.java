package main;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Questa classe si occupa di costruire tutti i thread, passando ad ognuno una riga di pixel differente su cui
 * fare il calcoli
 */
public class ThreadFactory {
	private BufferedImage image;
	private int[] rowPixels;
	private RowThread rowThreads[];

	/**
	 * Costruisce una ThreadFactory data una certa immagine
	 * @param image l'immagine da trattare
	 */
	public ThreadFactory(BufferedImage image) {
		this.image = image;
		rowThreads = new RowThread[image.getHeight()]; // creazione del numero di istanze di RowThread
	}

	/**
	 * Costruisce tutti i thread, assegna una riga a ciascuno di essi.
	 * Poi cerca, tra tutti i risultati, il maggiore, ovvero la riga con più pixel uguali consecutivi
	 */
	public void start() {
		// assegna una riga di pixel ad ogni thread
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
		Color c = new Color(pixel);	//per poter far vedere il risultato in formato RGB
		System.out.println("row: " + rowNumber + " pixel: " + pixel + " sequenza: " + maxSequence);
		System.out.println("Colore: " + " " + c.getRed() +  " " + c.getGreen() + " " + c.getBlue());
		new ColorFrame(c, rowNumber, maxSequence);
	}
}
