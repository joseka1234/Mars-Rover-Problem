package rover.problem.model;

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
	public void moveToDirection(Direction dir, Plateau plateau) throws ProgramException{ 
		switch (dir) {
		case N:
			if (getY() + 1 <= plateau.getHeight()) {
				setY(getY() + 1);
			} else {
				throw new ProgramException("You tried to leave the plateau.");
			}
			break;
		case S:
			if (getY() - 1 >= 0) {
				setY(getY() - 1);
			} else {
				throw new ProgramException("You tried to leave the plateau.");
			}
			break;
		case E:
			if (getX() + 1 <= plateau.getWidth()) {
				setX(getX() + 1);
			} else {
				throw new ProgramException("You tried to leave the plateau.");
			}
			break;
		case W:
			if (getX() - 1 >= 0) {
				setX(getX() - 1);
			} else {
				throw new ProgramException("You tried to leave the plateau.");
			}
			break;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", getX(), getY());
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
