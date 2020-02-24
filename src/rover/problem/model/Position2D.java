package rover.problem.model;

public class Position2D extends Position {
	private int x;
	private int y;
	
	public Position2D(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Gets the X coordinate
	 * @return
	 */
	public int getX() { return this.x; }
	
	/**
	 * Sets the X coordinate 
	 * @param x
	 */
	public void setX(int x) { this.x = x; }
	
	/**
	 * Gets the Y coordinate
	 * @return
	 */
	public int getY() { return this.y; }
	
	/**
	 * Sets the Y coordinate
	 * @param y
	 */
	public void setY(int y) { this.y = y; }
}
