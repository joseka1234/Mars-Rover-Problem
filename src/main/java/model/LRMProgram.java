package main.java.model;

public class LRMProgram extends Program{
	public LRMProgram(String commands) {
		super(commands);
	}
	
	/**
	 * Executes the program of a concrete Rover
	 */
	@Override
	public void Execute(Rover rover, Plateau plateau) throws ProgramException {
		for (char command : getCommands().toCharArray()) {
			switch (command) {
				case 'L':
					rover.setDirection(Direction.GetLeft(rover.getDirection()));
					break;
				case 'R':
					rover.setDirection(Direction.GetRight(rover.getDirection()));
					break;
				case 'M':
					rover.getPosition().moveToDirection(rover.getDirection(), plateau);
					break;
				default:
					throw new ProgramException(String.format("Error: Command %c not found", command));
			}
		}
	}
}
