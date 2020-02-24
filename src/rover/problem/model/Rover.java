package rover.problem.model;

public class Rover {
	private Position position;
	private Direction direction;
	private Program program;
	
	public Rover(Position pos, Direction dir, Program prog) {
		setPosition(pos);
		setDirection(dir);
		setProgram(prog);
	}
	
	public void ExecuteProgram() {
		
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
	
	/**
	 * Gets the program of the Rover
	 * @return
	 */
	private Program getProgram() {
		return program;
	}

	/**
	 * Sets the program of the rover
	 * @param program
	 */
	private void setProgram(Program program) {
		this.program = program;
	}
}
