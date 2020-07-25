package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe con punto di ingresso del programma
 *
 */
public class Startup {
	/**
	 * Ingresso del programma.
	 * Accetta un'immagine e ne trova la riga con il massimo numero di pixel consecutivi uguali e la codifica rgb di tali pixel
	 * @param args gli argomenti dalla riga di comando
	 */
	public static void main(String[] args) {
		BufferedImage i;
		try {			
			i = ImageIO.read(new File(args[0])); 			
			ThreadFactory tf = new ThreadFactory(i);
			tf.start();
		} catch (IOException e) {
			System.out.println("Eccezione di IO, il path dell'immagine potrebbe essere sbagliato oppure il file non è supportato");
			//Teoricamente questo pezzo serve se l'utente non inserisce un'immagine
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Uso: Inserire un'immagine come argomento.");
		}

	}
}
