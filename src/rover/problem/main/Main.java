package rover.problem.main;
import java.io.*;

import rover.problem.controller.RoverController;
import rover.problem.model.Direction;
import rover.problem.model.LRMProgram;
import rover.problem.model.Plateau;
import rover.problem.model.Position2D;
import rover.problem.model.ProgramException;
import rover.problem.model.Rover;

public class Main {
	private static final String FILE_PATH = "D:\\Proyectos\\Java\\Mars Rover Problem\\Data\\RoverData.data";
	
	public Main() {}
	
	public static void main(String[] args) {
		File file;
		if (args.length > 0) {
			file = new File(args[0]);
		} else {
			file = new File(FILE_PATH);
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String[] size = line.split(" ");
			Plateau plateau = new Plateau(Integer.parseInt(size[0]), Integer.parseInt(size[1]));
			RoverController controller = new RoverController(plateau);
			while ((line = br.readLine()) != null) {
				String[] roverString = line.split(" ");
				int x = Integer.parseInt(roverString[0]);
				int y = Integer.parseInt(roverString[1]);
				
				Rover rover = new Rover(new Position2D(x,y), Direction.valueOf(roverString[2]));
				controller.getRovers().add(new Rover(rover));
				controller.getPrograms().add(new LRMProgram(br.readLine()));
			}
			controller.ExecuteProgram();
			controller.PrintRovers();
			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ProgramException e) {
			e.printStackTrace();
		}
	
	}
}
