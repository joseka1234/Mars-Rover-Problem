package main.java.main;

import java.io.*;
import main.java.controller.RoverController;
import main.java.model.Direction;
import main.java.model.LRMProgram;
import main.java.model.Plateau;
import main.java.model.Position2D;
import main.java.model.ProgramException;
import main.java.model.Rover;
import main.java.model.RoverLoadException;

public class Main {
	public Main() {}
	
	public static void main(String[] args) throws RoverLoadException, IOException, ProgramException {
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		String[] size = line.split(" ");
		
		int plateauWidth = Integer.parseInt(size[0]);
		int plateauHeight = Integer.parseInt(size[1]);
		
		if (plateauHeight <= 0 || plateauWidth <= 0) {
			br.close();
			throw new RoverLoadException("The plateau can't have negative size.");
		}
		
		Plateau plateau = new Plateau(plateauWidth, plateauHeight);
		RoverController controller = new RoverController(plateau);
		
		while ((line = br.readLine()) != null) {
			String[] roverString = line.split(" ");
			int x = Integer.parseInt(roverString[0]);
			int y = Integer.parseInt(roverString[1]);
			
			if (isRoverInsidePlateau(x, y, plateau)) {
				Rover rover = new Rover(new Position2D(x,y), Direction.valueOf(roverString[2]), new LRMProgram(br.readLine()));
				controller.getRovers().add(rover);
			} else {
				br.close();
				throw new RoverLoadException("The rover is outside the plateau");
			}
		}
		
		controller.ExecuteProgram();
		controller.PrintRovers();
		br.close();
	}
	
	/**
	 * Check if the rover is inside the plateau 
	 * @param x
	 * @param y
	 * @param plateau
	 * @return
	 */
	private static boolean isRoverInsidePlateau(int x, int y, Plateau plateau) {
		return x <= plateau.getHeight() && x >= 0 && y <= plateau.getHeight() && y >= 0;
	}

}