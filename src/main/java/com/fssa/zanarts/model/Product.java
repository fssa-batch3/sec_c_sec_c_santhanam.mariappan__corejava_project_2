package com.fssa.zanarts.model;

import java.time.LocalDateTime;

/**
 * 
 * @author Santhanam Mariappan // Model object for my project "Product"
 *         Represents a product in the Zanarts project. This class encapsulates
 *         various attributes of a product, such as its name, artist, price, and
 *         more.
 *
 */

public class Product {

//	Declaring attributes
	private int id;
	private String productname;
	private String artistname;
	private double price;
	private LocalDateTime uploadTime;
	private String productDescription;
	private String imageurl;
	private Dimension size;
	private Types category;

	/**
	 * Enumerates the different types of art categories.
	 */

//	private String category;

	

	/**
	 * Constructs a new Product instance with specified attributes.
	 *
	 * @param id                 The unique identifier of the product.
	 * @param productName        The name of the product.
	 * @param artistName         The name of the artist who created the product.
	 * @param price              The price of the product.
	 * @param uploadTime         The date and time when the product was uploaded.
	 * @param productDescription A description of the product.
	 * @param imageUrl           The URL to the image representing the product.
	 * @param size               The dimensions of the product.
	 * @param category           The category of the product.
	 */

	public Product(int id, String productname, String artistname, double price, LocalDateTime uploadTime,
			String productDescription, String imageurl, Dimension size, Types category) {
		super();
		this.id = id;
		this.productname = productname;
		this.artistname = artistname;
		this.price = price;
		this.uploadTime = uploadTime;
		this.productDescription = productDescription;
		this.imageurl = imageurl;
		this.size = size;
		this.category = category;
	}

	/**
	 * Default constructor for Product class.
	 */
	public Product() {

	}
	// Getters and setters for attributes

	// ... (Getters and setters for other attributes)

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getUrl() {
		return imageurl;
	}

	public void setUrl(String url) {
		this.imageurl = url;
	}

	public Types getCategory() {
		return category;
	}

	public void setCategory(Types category) {
		this.category = category;
	}

	public LocalDateTime getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(LocalDateTime uploadTime) {
		this.uploadTime = uploadTime;
	}

}
