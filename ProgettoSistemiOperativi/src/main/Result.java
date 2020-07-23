package main;

public class Result {
	private int rowNumber;
	private int pixelValue;
	private int maxSequenceValue;	//numero di pixel consecutivi uguali
	public Result(int rowNumber, int pixelValue, int maxSequenceValue) {
		this.rowNumber = rowNumber;
		this.pixelValue = pixelValue;
		this.maxSequenceValue = maxSequenceValue;
	}
	

	/**
	 * @return the rowNumber
	 */
	public int getRowNumber() {
		return rowNumber;
	}
	/**
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	/**
	 * @return the pixelValue
	 */
	public int getPixelValue() {
		return pixelValue;
	}
	/**
	 * @param pixelValue the pixelValue to set
	 */
	public void setPixelValue(int pixelValue) {
		this.pixelValue = pixelValue;
	}
	/**
	 * @return the result
	 */
	public int getResult() {
		return maxSequenceValue;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.maxSequenceValue = result;
	}
	
	
}
