package rover.problem.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rover.problem.controller.RoverController;
import rover.problem.model.Direction;
import rover.problem.model.LRMProgram;
import rover.problem.model.Plateau;
import rover.problem.model.Position2D;
import rover.problem.model.ProgramException;
import rover.problem.model.Rover;


class RoverTests {
	
	@Test
	void test_direction() {
		Direction dir = Direction.N;
		assertEquals(Direction.GetLeft(dir), Direction.W);
		assertEquals(Direction.GetRight(dir), Direction.E);
	}
	
	@Test
	void test_movement() {
		Plateau plateau = new Plateau(10, 10);
		Position2D position = new Position2D(1, 1);
		
		assertDoesNotThrow(() -> position.moveToDirection(Direction.N, plateau));
		assertArrayEquals(new int[] {position.getX(), position.getY()}, new int[] {1, 2});
		
		assertDoesNotThrow(() -> position.moveToDirection(Direction.E, plateau));
		assertArrayEquals(new int[] {position.getX(), position.getY()}, new int[] {2, 2});
		
		assertDoesNotThrow(() -> position.moveToDirection(Direction.S, plateau));
		assertArrayEquals(new int[] {position.getX(), position.getY()}, new int[] {2, 1});
		
		assertDoesNotThrow(() -> position.moveToDirection(Direction.W, plateau));
		assertArrayEquals(new int[] {position.getX(), position.getY()}, new int[] {1, 1});
		
		Position2D position2 = new Position2D(0, 0);
		assertThrows(ProgramException.class, () -> position2.moveToDirection(Direction.S, plateau));
	}
	
	@Test
	void test_rover_program_execution() {
		Plateau plateau = new Plateau(10, 10);
		Rover r1 = new Rover(new Position2D(1,1), Direction.N);
		
		RoverController rc1 = new RoverController(plateau);
		rc1.getRovers().add(r1);
		rc1.getPrograms().add(new LRMProgram("LMLMRMMMRM"));
		assertDoesNotThrow(() -> rc1.ExecuteProgram());
		assertEquals("0 1 N", r1.toString());

		RoverController rc2 = new RoverController(plateau);
		rc2.getRovers().add(r1);
		rc2.getPrograms().add(new LRMProgram("LMLMRTM"));
		assertThrows(ProgramException.class, () -> rc2.ExecuteProgram());
		
		Rover r2 = new Rover(new Position2D(0, 0), Direction.S);
		RoverController rc3 = new RoverController(plateau);
		rc3.getRovers().add(r2);
		rc3.getPrograms().add(new LRMProgram("RRMMRMM"));
		assertDoesNotThrow(() -> rc3.ExecuteProgram());
		assertEquals("2 2 E", r2.toString());	
	}

}
