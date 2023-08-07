package com.fssa.zanarts.model;

/**
 * Represents the dimensions (height and width) of an object, such as a product
 * or an image.
 */

public class Dimension {

	private int height;
	private int width;

	public Dimension(int height, int width) {
		this.height = height;
		this.width = width;
	}

	/**
	 * Constructs a new Dimension instance with specified height and width.
	 *
	 * @param height The height value.
	 * @param width  The width value.
	 */
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
