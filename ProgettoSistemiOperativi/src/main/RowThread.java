package main;

public class RowThread extends Thread {

	private int[] rowPixels;
	
	public RowThread(int[] rowPixels) {
		this.rowPixels = rowPixels;
	}
	
	@Override
	public void run() {
		System.out.println(rowPixels.length);
		for(int i = 0; i < rowPixels.length; i++) {
			System.out.println(rowPixels[i]);
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

	
	
}
