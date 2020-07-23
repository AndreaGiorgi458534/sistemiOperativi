package main;

public class RowThread extends Thread {

	private int rowNumber;
	private int[] rowPixels;
	private int maxPixelValue;
	private int maxSequence;

	public RowThread(int rowNumber, int[] rowPixels) {
		this.rowNumber = rowNumber;
		this.rowPixels = rowPixels;
	}

	@Override
	public void run() {
		// DEBUG per capire se funge
		System.out.println("riga: " + rowNumber);
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

	public int getMaxPixelValue() {
		return maxPixelValue;
	}

	public int getMaxSequence() {
		return maxSequence;
	}

}
