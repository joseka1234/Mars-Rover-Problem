package main.java.controller;

import java.util.ArrayList;

import main.java.model.Plateau;
import main.java.model.Program;
import main.java.model.ProgramException;
import main.java.model.Rover;

public class RoverController {
	private ArrayList<Rover> rovers;
	private ArrayList<Program> programs;
	private Plateau plateau;
	
	public RoverController(Plateau plateau) {
		setPlateau(plateau);
		setRovers(new ArrayList<Rover>());
		setPrograms(new ArrayList<Program>());
	}
	
	/**
	 * Execute the program passed to the rover
	 */
	public void ExecuteProgram() throws ProgramException{
		for (int i = 0; i < getRovers().size(); i++) {
			getPrograms().get(i).Execute(getRovers().get(i), getPlateau());
		}
	}
	
	/**
	 * Adds a rover and a program because it needs to be 1:1 relation.
	 * @param rover
	 * @param program
	 */
	public void AddRoverProgram(Rover rover, Program program) throws ProgramException{
		if (rover != null) {
			getRovers().add(rover);
		} else {
			throw new ProgramException("The rover can't be NULL");
		}
		
		if (program != null) {
			getPrograms().add(program);
		} else {
			throw new ProgramException("The program can't be NULL");
		}
	}
	
	/**
	 * Prints the rovers in the format passed by email
	 */
	public void PrintRovers() {
		for (Rover rov : getRovers()) {
			System.out.println(rov);
		}
	}
	
	// Getters and Setters
	private Plateau getPlateau() { return plateau; }
	private void setPlateau(Plateau plateau) { this.plateau = plateau; }
	private ArrayList<Rover> getRovers() { return rovers; }
	private void setRovers(ArrayList<Rover> rovers) { this.rovers = rovers; }
	private ArrayList<Program> getPrograms() { return programs; }
	private void setPrograms(ArrayList<Program> programs) {	this.programs = programs; }
}
