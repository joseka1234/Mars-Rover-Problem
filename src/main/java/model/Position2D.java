package main.java.model;

public class Position2D extends Position {
	private int x;
	private int y;
	
	public Position2D(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Gets the next position given a direction and a plateau which can't be exited of
	 */
	@Override
	public void moveToDirection(Direction dir, Plateau plateau) {
		
		if (dir == Direction.N || dir == Direction.S) {
			int newY = (dir == Direction.N) ? getY() + 1 : getY() - 1;
			setY(Clamp(newY, 0, plateau.getHeight()));
		}
		
		if (dir == Direction.E || dir == Direction.W) {
			int newX = (dir == Direction.E) ? getX() + 1 : getX() - 1;
			setX(Clamp(newX, 0, plateau.getWidth()));
		}
	}
	
	/**
	 * Clamps a number between two limits
	 * @param number
	 * @param min
	 * @param max
	 * @return
	 */
	private int Clamp(int number, int min, int max) {
		return Math.max(min, Math.min(number, max));
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", getX(), getY());
	}
	
	// Getters and setters
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