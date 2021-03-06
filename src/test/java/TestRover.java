package test.java;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import main.java.controller.RoverController;
import main.java.main.Main;
import main.java.model.Direction;
import main.java.model.LRMProgram;
import main.java.model.Plateau;
import main.java.model.Position2D;
import main.java.model.ProgramException;
import main.java.model.Rover;
import main.java.model.RoverLoadException;


class TestRover {
	@Test
	void test_main() {
		assertDoesNotThrow(() -> Main.main(new String[] {".\\Data\\RoverData.data"}));
		assertThrows(IOException.class, () -> Main.main(new String[] {".\\NoPath"}));
		assertThrows(ProgramException.class, () -> Main.main(new String[] {".\\Data\\RoverWithErrorInProgram.data"}));
		assertThrows(RoverLoadException.class, () -> Main.main(new String[] {".\\Data\\NegativePlateau.data"}));
		assertThrows(RoverLoadException.class, () -> Main.main(new String[] {".\\Data\\RoverOutOfPlateau.data"}));
	}
	
	@Test
	void test_direction() {
		assertEquals(Direction.W, Direction.GetLeft(Direction.N));
		assertEquals(Direction.E, Direction.GetRight(Direction.N));
		assertEquals(Direction.N, Direction.GetRight(Direction.W));
	}
	
	@Test
	void test_movement() {
		Plateau plateau = new Plateau(10, 10);
		Position2D position = new Position2D(1, 1);
		
		assertDoesNotThrow(() -> position.moveToDirection(new ArrayList<Rover>(), Direction.N, plateau));
		assertArrayEquals(new int[] {1, 2}, new int[] {position.getX(), position.getY()});
		
		assertDoesNotThrow(() -> position.moveToDirection(new ArrayList<Rover>(), Direction.E, plateau));
		assertArrayEquals(new int[] {2, 2}, new int[] {position.getX(), position.getY()});
		
		assertDoesNotThrow(() -> position.moveToDirection(new ArrayList<Rover>(), Direction.S, plateau));
		assertArrayEquals(new int[] {2, 1}, new int[] {position.getX(), position.getY()});
		
		assertDoesNotThrow(() -> position.moveToDirection(new ArrayList<Rover>(), Direction.W, plateau));
		assertArrayEquals(new int[] {1, 1}, new int[] {position.getX(), position.getY()});
	}
	
	@Test
	void test_rover_program_execution() {
		Plateau plateau = new Plateau(10, 10);
		Rover r1 = new Rover(new Position2D(1,1), Direction.N, new LRMProgram("LMLMRMMMRM"));
		RoverController rc1 = new RoverController(plateau);
		rc1.getRovers().add(r1);
		assertDoesNotThrow(() -> rc1.ExecuteProgram());
		assertEquals(r1.toString(), "0 1 N");

		RoverController rc2 = new RoverController(plateau);
		rc2.getRovers().add(new Rover(new Position2D(1,1), Direction.N, new LRMProgram("LMLMRTM")));
		assertThrows(ProgramException.class, () -> rc2.ExecuteProgram());
		
		Rover r2 = new Rover(new Position2D(0, 0), Direction.S, new LRMProgram("RRMMRMM"));
		RoverController rc3 = new RoverController(plateau);
		rc3.getRovers().add(r2);
		assertDoesNotThrow(() -> rc3.ExecuteProgram());
		assertEquals(r2.toString(), "2 2 E");
	}
}
