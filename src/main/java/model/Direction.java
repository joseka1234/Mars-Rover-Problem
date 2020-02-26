package main.java.model;

public enum Direction {
	// To add new directions we need to add them with a turning to the left every time.
	N, E, S, W;
	
	/**
	 * Get the direction if we turn to the left
	 * @param dir
	 * @return
	 */
	public static Direction GetLeft(Direction dir) {
		Direction[] values = Direction.values();
		return dir.ordinal() == 0 ? values[values.length - 1] : values[dir.ordinal() - 1];
	}
		
	/**
	 * Get the direction if we turn to the right
	 * @param dir
	 * @return
	 */
	public static Direction GetRight(Direction dir) {
		Direction[] values = Direction.values();
		return dir.ordinal() == values.length - 1 ? values[0] : values[dir.ordinal() + 1];
	}
}