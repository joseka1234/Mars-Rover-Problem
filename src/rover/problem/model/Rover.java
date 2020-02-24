package rover.problem.model;

public class Rover {
	private Position position;
	private Direction direction;
		
	public Rover(Position pos, Direction dir) {
		setPosition(pos);
		setDirection(dir);
	}
	
	public Rover(Rover rover) {
		setPosition(rover.getPosition());
		setDirection(rover.getDirection());
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", position.toString(), direction.toString());
	}
	
	// Getters and Setters
	/**
	 * Returns the position
	 * @return
	 */
	public Position getPosition() {
		return this.position;
	}
	
	/**
	 * Sets the position
	 * @param pos
	 */
	public void setPosition(Position pos) {
		this.position = pos;
	}
	
	/**
	 * Returns the direction
	 * @return
	 */
	public Direction getDirection() {
		return this.direction;
	}
	
	/**
	 * Sets the direction
	 * @param dir
	 */
	public void setDirection(Direction dir) {
		this.direction = dir;
	}
}
