package rover.problem.model;

public enum Direction {
	N(0), E(1), S(2), W(3);
	
	private int value;
	Direction(int value) {
		this.value = value;
	}

	/**
	 * Get a direction from its value
	 * @param value
	 * @return
	 */
	private static Direction fromValue(int value) {
		switch (value) {
			case 0: return N;
			case 1: return E;
			case 2: return S;
			case 3: return W;
			default:  return N;
		}
	}
	
	/**
	 * Get the direction if we turn to the left
	 * @param dir
	 * @return
	 */
	public Direction GetLeft(Direction dir) {
		return dir == N ? W : fromValue(dir.value - 1);
	}
		
	/**
	 * Get the direction if we turn to the right
	 * @param dir
	 * @return
	 */
	public Direction GetRight(Direction dir) {
		return dir == W ? N : fromValue(dir.value + 1);
	}
}