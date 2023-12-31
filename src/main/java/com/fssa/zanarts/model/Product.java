package com.fssa.zanarts.model;

import java.time.LocalDateTime;

import com.fssa.zanarts.enumclass.Types;

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
	private String name; // Todo
	private String artistname;
	private double price;
	private LocalDateTime uploadTime;
	private String Description; // Todo
	private String imageurl;
	private Dimension size;
	private String userid;
	private Types category;


	/**
	 * Enumerates the different types of art categories.
	 */

//	private String category;

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userid) {
		this.userid = userid;
	}

	/**
	 * Constructs a new Product instance with specified attributes.
	 *
	 * @param id                 The unique identifier of the product.
	 * @param name        The name of the product.
	 * @param artistName         The name of the artist who created the product.
	 * @param price              The price of the product.
	 * @param uploadTime         The date and time when the product was uploaded.
	 * @param productDescription A description of the product.
	 * @param imageUrl           The URL to the image representing the product.
	 * @param size               The dimensions of the product.
	 * @param category           The category of the product.
	 */

	public Product(int id, String name, String artistname, double price, LocalDateTime uploadTime,
			String productDescription, String imageurl, Dimension size,String userid, Types category) {
		super();
		this.id = id;
		this.name = name;
		this.artistname = artistname;
		this.price = price;
		this.uploadTime = uploadTime;
		this.Description = productDescription;
		this.imageurl = imageurl;
		this.size = size;
		this.userid=userid;
		this.category = category;
	}

	/**
	 * Default constructor for Product class.
	 */
	public Product() {

	}
	// Getters and setters for attributes

	/**
	 * Gets the image URL of the product.
	 *
	 * @return The image URL of the product.
	 */

	public String getImageurl() {
		return imageurl;
	}

	/**
	 * Sets the image URL of the product.
	 *
	 * @param imageurl The image URL to set for the product.
	 */
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	/**
	 * Gets the dimensions of the product.
	 *
	 * @return The dimensions of the product.
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * Sets the dimensions of the product.
	 *
	 * @param size The dimensions to set for the product.
	 */

	public void setSize(Dimension size) {
		this.size = size;
	}

	/**
	 * Gets the ID of the product.
	 *
	 * @return The ID of the product.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the product.
	 *
	 * @param id The ID to set for the product.
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name of the product.
	 *
	 * @return The name of the product.
	 */
	public String getname() {
		return name;
	}

	/**
	 * Sets the name of the product.
	 *
	 * @param name The name to set for the product.
	 */
	public void setname(String name) {
		this.name = name;
	}

	/**
	 * Gets the artist name of the product.
	 *
	 * @return The artist name of the product.
	 */
	public String getArtistname() {
		return artistname;
	}

	/**
	 * Sets the artist name of the product.
	 *
	 * @param artistname The artist name to set for the product.
	 */
	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	/**
	 * Gets the price of the product.
	 *
	 * @return The price of the product.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the product.
	 *
	 * @param price The price to set for the product.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the description of the product.
	 *
	 * @return The description of the product.
	 */
	public String getProductDescription() {
		return Description;
	}

	/**
	 * Sets the description of the product.
	 *
	 * @param productDescription The description to set for the product.
	 */

	public void setProductDescription(String productDescription) {
		this.Description = productDescription;
	}

	/**
	 * Gets the image URL of the product.
	 *
	 * @return The image URL of the product.
	 */
	public String getUrl() {
		return imageurl;
	}

	/**
	 * Sets the image URL of the product.
	 *
	 * @param imageurl The image URL to set for the product.
	 */

	public void setUrl(String url) {
		this.imageurl = url;
	}

	/**
	 * Gets the category of the product.
	 *
	 * @return The category of the product.
	 */
	public Types getCategory() {
		return category;
	}

	/**
	 * Sets the category of the product.
	 *
	 * @param category The category to set for the product.
	 */
	public void setCategory(Types category) {
		this.category = category;
	}

	/**
	 * Gets the upload time of the product.
	 *
	 * @return The upload time of the product.
	 */
	public LocalDateTime getUploadTime() {
		return uploadTime;
	}

	/**
	 * Sets the upload time of the product.
	 *
	 * @param uploadTime The upload time to set for the product.
	 */
	public void setUploadTime(LocalDateTime uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", artistname=" + artistname + ", price=" + price
				+ ", uploadTime=" + uploadTime + ", Description=" + Description + ", imageurl=" + imageurl + ", size="
				+ size + ", category=" + category + "]";
	}

}
