package rover.problem.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rover.problem.model.Direction;
import rover.problem.model.Position2D;
import rover.problem.model.Program;
import rover.problem.model.Rover;


class RoverTests {

	@Test
	void test_movement() {
		Rover r1 = new Rover(new Position2D(1,1), Direction.N, new Program("LMLMRMMMRM"));
		r1.ExecuteProgram();
		assertEquals("-3 0 N", r1.toString());
	}

}
