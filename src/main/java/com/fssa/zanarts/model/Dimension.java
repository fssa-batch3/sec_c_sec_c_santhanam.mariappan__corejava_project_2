package com.fssa.zanarts.model;

//create a object for representing size

public class Dimension {

	private int height;
	private int width;

	public Dimension(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public Dimension() {
		// TODO Auto-generated constructor stub
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
 