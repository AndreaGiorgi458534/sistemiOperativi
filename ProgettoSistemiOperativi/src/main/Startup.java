package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Startup {
	
	public static void main(String[] args) {
		BufferedImage i;
		try {
			 i = ImageIO.read(new File("resources/4 te ghiacciati.jpg"));
			System.out.println("Tutto Bene");
			ThreadFactory tf = new ThreadFactory(i);
			tf.start();
			
			
		} catch (IOException e) {
			System.out.println("Eccezione di IO, si vede che il path dell'immagine è sbagliato");
		}
		
		
	}
}
