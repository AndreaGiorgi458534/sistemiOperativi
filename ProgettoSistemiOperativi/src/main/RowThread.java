package main;

import java.util.Vector;

public class RowThread extends Thread {

	private int rowNumber;
	private int[] rowPixels;
	private Vector<Result> results;
	
	public RowThread(int rowNumber, int[] rowPixels, Vector<Result> results) {
		this.rowNumber = rowNumber;
		this.rowPixels = rowPixels;
		this.results = results;
	}
	
	@Override
	public void run() {
		/*
		System.out.println(rowPixels.length);
		for(int i = 0; i < rowPixels.length; i++) {
			System.out.println(rowPixels[i]);
		}
		*/
		//DEBUG per capire se funge
		System.out.println("riga: " + rowNumber);
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

	
	
}
