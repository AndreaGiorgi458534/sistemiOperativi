package main;
/**
 * Thread secondario del progetto.
 * Questa classe si occupa, data una certa riga di pixel, di calcolare la più lunga fila di pixel uguali
 *
 */
public class RowThread extends Thread {

	private int rowNumber;		//numero di riga
	private int[] rowPixels;	//array di pixel in formato rgb
	private int maxPixelValue;	//valore del pixel cercato
	private int maxSequence;	//numero di occorrenze consecutive del pixel cercato

	/**
	 * Costruisce il thread
	 * @param rowNumber numero della riga
	 * @param rowPixels array di pixel in formato rgb
	 */
	public RowThread(int rowNumber, int[] rowPixels) {
		this.rowNumber = rowNumber;
		this.rowPixels = rowPixels;
	}
	
	@Override
	/**
	 * Metodo di run del thread. Implementa l'algoritmo di ricerca, memorizzando
	 * il pixel che compare più volte di seguito
	 */
	public void run() {
		// DEBUG per capire se funge
		//System.out.println("riga: " + rowNumber);
		int sequence = 0;
		int previous = rowPixels[0];
		maxSequence = 0;
		maxPixelValue = rowPixels[0];
		for (int i = 0; i < rowPixels.length; i++) {
			if (rowPixels[i] == previous)
				sequence++;
			else
				sequence = 1; // ricomincia il conto da 1
			if (sequence > maxSequence) {
				maxSequence = sequence;
				maxPixelValue = rowPixels[i];
			}
			previous = rowPixels[i];
		}
	}

	/**
	 * @return the rowPixels
	 */
	public int[] getRowPixels() {
		return rowPixels;
	}

	/**
	 * @param rowPixels the rowPixels to set
	 */
	public void setRowPixels(int[] rowPixels) {
		this.rowPixels = rowPixels;
	}

	/**
	 * 
	 * @return valore del pixel più presente in questa riga
	 */
	public int getMaxPixelValue() {
		return maxPixelValue;
	}

	/**
	 * 
	 * @return occorrenza consecutiva maggiore in questa riga
	 */
	public int getMaxSequence() {
		return maxSequence;
	}

}
