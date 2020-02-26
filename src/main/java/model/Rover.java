package main.java.model;

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
		return String.format("%s %s", getPosition().toString(), getDirection().toString());
	}
	
	// Getters and Setters
	public Position getPosition() { return this.position; }
	public void setPosition(Position pos) { this.position = pos; }
	public Direction getDirection() { return this.direction; }
	public void setDirection(Direction dir) { this.direction = dir;	}
}
