package main.java.model;

public class ProgramException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6571721807021391129L;

	public ProgramException(String errorMessage) {
		super(errorMessage);
	}
}