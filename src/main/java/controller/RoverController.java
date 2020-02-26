package main.java.controller;

import java.util.ArrayList;

import main.java.model.Plateau;
import main.java.model.ProgramException;
import main.java.model.Rover;

public class RoverController {
	private ArrayList<Rover> rovers;
	private Plateau plateau;
	
	public RoverController(Plateau plateau) {
		setPlateau(plateau);
		setRovers(new ArrayList<Rover>());	}
	
	/**
	 * Execute the program passed to the rover
	 */
	public void ExecuteProgram() throws ProgramException{
		for (int i = 0; i < getRovers().size(); i++) {
			getRovers().get(i).getProgram().Execute(getRovers(), i, getPlateau());
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
	public ArrayList<Rover> getRovers() { return rovers; }
	private void setRovers(ArrayList<Rover> rovers) { this.rovers = rovers; }
}
