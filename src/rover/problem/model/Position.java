package rover.problem.model;

// Just in case we need to expand the dimensions of the rover.
public abstract class Position {
	
	/**
	 * Gets the position if we move in a certain direction
	 * @param dir
	 * @throws ProgramException 
	 */
	public void moveToDirection(Direction dir, Plateau plateau) throws ProgramException {}
}