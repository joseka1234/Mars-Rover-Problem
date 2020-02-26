package main.java.model;

import java.util.ArrayList;

// Just in case we need to expand the dimensions of the rover.
public abstract class Position {
	
	/**
	 * Gets the position if we move in a certain direction
	 * @param dir
	 * @throws ProgramException 
	 */
	public void moveToDirection(ArrayList<Rover> rovers, Direction dir, Plateau plateau) throws ProgramException {}
	
	/**
	 * Check if a position is equal to another
	 * @param pos
	 * @return
	 */
	public boolean equal(Position pos) { return true; }
	
	/**
	 * Clamps a number between two limits
	 * @param number
	 * @param min
	 * @param max
	 * @return
	 */
	protected int Clamp(int number, int min, int max) {
		return Math.max(min, Math.min(number, max));
	}
}