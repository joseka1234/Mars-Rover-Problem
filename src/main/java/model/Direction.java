package main.java.model;

public enum Direction {
	N, E, S, W;
	
	/**
	 * Get the direction if we turn to the left
	 * @param dir
	 * @return
	 */
	public static Direction GetLeft(Direction dir) {
		return dir == N ? W : Direction.values()[dir.ordinal() - 1];
	}
		
	/**
	 * Get the direction if we turn to the right
	 * @param dir
	 * @return
	 */
	public static Direction GetRight(Direction dir) {
		return dir == W ? N : Direction.values()[dir.ordinal() + 1];
	}
}