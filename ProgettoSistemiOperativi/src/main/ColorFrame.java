package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ColorFrame extends JFrame {
	public ColorFrame(Color c, int rowNum, int seq) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setSize((int)w/4, (int)h/4);
		setTitle("Risultato");
		JLabel textLabel = new JLabel(" Riga numero: " + rowNum + "Lunghezza Sequenza: " + seq + " "
				+ " Colore: " + c.getRed() + " " + c.getGreen() + " " + c.getBlue() + " ", SwingConstants.CENTER);
		
		JPanel label = new JPanel();
		label.setBackground(c);
		setLayout(new GridLayout(2, 1));
		getContentPane().add(textLabel);
		getContentPane().add(label);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
