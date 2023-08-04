package com.fssa.zanarts.model;

import java.time.LocalDateTime;

/**
 * 
 * @author SanthanamMariappan Model object for my project "Product"
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
	
//	ennum for categories of art
	
	private String category;

	public enum Types {
		MANDANA, WATERCOLOUR, SKETCH, REALISM, HYPERREALISM;
	}

	public Product(int id, String productname, String artistname, double price, LocalDateTime uploadTime,
			String productDescription, String imageurl, Dimension size, String category) {
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
	 
	public Product() {

	}
//	setting and getting the values

 
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

	public String getCategory() {
		return category ;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(LocalDateTime uploadTime) {
		this.uploadTime = uploadTime;
	}

}
