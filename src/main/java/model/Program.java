package main.java.model;

// Just in case we expand the command options
public abstract class Program {
	protected String commands;
	
	public Program(String commands) {
		this.setCommands(commands);
	}
	
	public Program(Program program) {
		setCommands(program.getCommands());
	}
	
	/**
	 * Execute the commands
	 */
	public void Execute(Rover rover, Plateau plateau) throws ProgramException {}
	
	// Getters and setters
	protected String getCommands() { return commands; }
	protected void setCommands(String commands) { this.commands = commands;	}
}
