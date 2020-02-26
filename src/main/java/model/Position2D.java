package main.java.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Position2D extends Position {
	private int x;
	private int y;
	
	public Position2D(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Gets the next position given a direction and a plateau which can't be exited of
	 */
	@Override
	public void moveToDirection(ArrayList<Rover> rovers, Direction dir, Plateau plateau) {
		if (dir == Direction.N || dir == Direction.S) {
			int newY = (dir == Direction.N) ? getY() + 1 : getY() - 1;
			if (isPositionFree(rovers, newY, getX())) {
				setY(Clamp(newY, 0, plateau.getHeight()));
			}
		}
		
		if (dir == Direction.E || dir == Direction.W) {
			int newX = (dir == Direction.E) ? getX() + 1 : getX() - 1;
			if (isPositionFree(rovers, getY(), newX)) {
				setX(Clamp(newX, 0, plateau.getWidth()));
			}
		}
	}
	
	/**
	 * Check if a position is free checking the rover positions
	 * @param rovers
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isPositionFree(ArrayList<Rover> rovers, int x, int y) {
		return rovers.stream().filter(rover -> rover.getPosition().equal(new Position2D(x, y))).collect(Collectors.toList()).size() == 0;
	}
	
	/**
	 * Check if a position is equal to another
	 * @param pos
	 * @return
	 */
	@Override
	public boolean equal(Position pos) {
		Position2D pos2d = (Position2D) pos;
		return getX() == pos2d.getX() && getY() == pos2d.getY();
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", getX(), getY());
	}
	
	// Getters and setters
	public int getX() { return this.x; }
	private void setX(int x) { this.x = x; }
	public int getY() { return this.y; }
	private void setY(int y) { this.y = y; }
}