package main.java.model;

import java.util.ArrayList;

public class LRMProgram extends Program{
	public LRMProgram(String commands) {
		super(commands);
	}
	
	/**
	 * Executes the program of a concrete Rover
	 */
	@Override
	public void Execute(ArrayList<Rover> rovers, int roverIndex, Plateau plateau) throws ProgramException {
		Rover rover = rovers.get(roverIndex);
		for (char command : getCommands().toCharArray()) {
			switch (command) {
				case 'L':
					rover.setDirection(Direction.GetLeft(rover.getDirection()));
					break;
				case 'R':
					rover.setDirection(Direction.GetRight(rover.getDirection()));
					break;
				case 'M':
					rover.getPosition().moveToDirection(rovers, rover.getDirection(), plateau);
					break;
				default:
					throw new ProgramException(String.format("Error: Command %c not found", command));
			}
		}
	}
}
