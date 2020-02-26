package main.java.model;

public class Plateau {
	private int Width;
	private int Height;
	
	public Plateau(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	// Getters and Setters
	public int getWidth() {
		return Width;
	}
	private void setWidth(int width) {
		Width = width;
	}
	public int getHeight() {
		return Height;
	}
	private void setHeight(int height) {
		Height = height;
	}
	
	
}
