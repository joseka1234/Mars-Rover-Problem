package rover.problem.main;

import java.io.*;
import rover.problem.controller.RoverController;
import rover.problem.model.Direction;
import rover.problem.model.LRMProgram;
import rover.problem.model.Plateau;
import rover.problem.model.Position2D;
import rover.problem.model.ProgramException;
import rover.problem.model.Rover;
import rover.problem.model.RoverLoadException;

public class Main {	
	public Main() {}
	
	public static int main(String[] args) throws RoverLoadException {
		try {
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
					Rover rover = new Rover(new Position2D(x,y), Direction.valueOf(roverString[2]));
					controller.AddRoverProgram(new Rover(rover), new LRMProgram(br.readLine()));
				} else {
					br.close();
					throw new RoverLoadException("The rover is outside the plateau");
				}
			}
			
			controller.ExecuteProgram();
			controller.PrintRovers();
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
			return 1;
		} catch(ProgramException e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
	}
	
	private static boolean isRoverInsidePlateau(int x, int y, Plateau plateau) {
		return x <= plateau.getHeight() && x >= 0 && y <= plateau.getHeight() && y >= 0;
	}

}