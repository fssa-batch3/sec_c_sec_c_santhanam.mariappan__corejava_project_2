package com.fssa.zanarts.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

/**
 * Provides methods for validating various attributes of a Product object.
 */

public class ProductValidator {

	/**
	 * Validates the given Product object.
	 *
	 * @param product The Product object to validate.
	 * @return {@code true} if the Product is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the Product is not valid.
	 */
	public static boolean validate(Product product) throws ProductExpection {

		if (product == null) {
			throw new ProductExpection(CustomErrors.INVALID_OBJECT_NULL);
		}

		validateName(product.getname());
		validateProductId(product.getId());
		validateArtistName(product.getArtistname());
		validateDescription(product.getProductDescription());
		validatePrice(product.getPrice());
		validateurl(product.getUrl());
//		validateDimension(product.getSize());
//		validCategory(product.getCategory());

		return true;

	}

	/**
	 * Validates a product name.
	 *
	 * @param name The name of the product.
	 * @return {@code true} if the name is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the name is not valid.
	 */
	public static boolean validateName(String name) throws ProductExpection {

		if (name == null || "".equals(name.trim())) {
			throw new ProductExpection(CustomErrors.INVALID_PRODUCTNAME_NULL);
		}

		String nameregex = "^[A-Za-z]{5,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(name);
		Boolean isMatch = matcher.matches();

		if (!isMatch)
			throw new ProductExpection(CustomErrors.INVALID_LENGTH_PRODUCT_NAME);

		return true;
	}

	/**
	 * Validates a product ID.
	 *
	 * @param id The ID of the product.
	 * @return {@code true} if the ID is valid, otherwise throws a CustomException.
	 * @throws CustomExpection If the ID is not valid.
	 */
	public static boolean validateProductId(int id) throws ProductExpection {

		if (id <= 0) {
			throw new ProductExpection(CustomErrors.INVALID_PRODUCTID);
		}

		return true;

	}

	/**
	 * Validates an artist name.
	 *
	 * @param artistName The name of the artist.
	 * @return {@code true} if the artist name is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the artist name is not valid.
	 */
	public static boolean validateArtistName(String artistName) throws ProductExpection {

		if (artistName == null || "".equals(artistName.trim())) { // "".equals(name.trim())
			throw new ProductExpection(CustomErrors.INVALID_ARTISTNAME_NULL);
		}

		String nameregex = "^[A-Za-z ]{3,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(artistName);
		Boolean isMatch = matcher.matches();

		if (isMatch)
			return true;

		throw new ProductExpection(CustomErrors.INVALID_ARTIST_NAME);

	}

	/**
	 * Validates a product description.
	 *
	 * @param description The description of the product.
	 * @return {@code true} if the description is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the description is not valid.
	 */
	public static boolean validateDescription(String description) throws ProductExpection {

		if (description == null || "".equals(description.trim())) {
			throw new ProductExpection(CustomErrors.INVALID_DESCRIPTION_NULL);
		}

		String regex = "^[A-Za-z ]{5,100}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(description);
		Boolean isMatch = matcher.matches();
		if (isMatch) {
			return true;
		}

		throw new ProductExpection(CustomErrors.INVALID_DESCRIPTION);

	}

	/**
	 * Validates a product price.
	 *
	 * @param price The price of the product.
	 * @return {@code true} if the price is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the price is not valid.
	 */
	public static boolean validatePrice(double price) throws ProductExpection {
		if (price <= 0) {
			throw new ProductExpection(CustomErrors.INVALID_PRICE);
		}
		return true;
	}

	/**
	 * Validates a URL.
	 *
	 * @param url The URL to validate.
	 * @return {@code true} if the URL is valid, otherwise throws a CustomException.
	 * @throws CustomExpection If the URL is not valid.
	 */
	public static boolean validateurl(String url) throws ProductExpection {
		if (url == null || "".equals(url.trim())) {
			throw new ProductExpection(CustomErrors.INVALID_NULL_URL);

		}

		String urlregex = "^(http|https)://.*\\.(jpg|jpeg|png|gif)$";

		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(url);
		Boolean isMatch = matcher.matches();

		if (isMatch) {
			return true;
		}
		throw new ProductExpection(CustomErrors.INVALID_URL);
	}

	/**
	 * Validates a Dimension object.
	 *
	 * @param dm The Dimension object to validate.
	 * @return {@code true} if the Dimension is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the Dimension is not valid.
	 */

	public static boolean validateDimension(Dimension dm) throws ProductExpection {

		if (dm.getHeight() <= 300 || dm.getHeight() >= 700) {
			throw new ProductExpection(CustomErrors.INVALID_WIDTH_AND_HEIGHT);
		}

		if (dm.getWidth() <= 500 || dm.getWidth() >= 1200) {
			throw new ProductExpection(CustomErrors.INVALID_WIDTH_AND_HEIGHT);
		}

		return true;

	}

	/**
	 * Validates a product category.
	 *
	 * @param types The category to validate.
	 * @return {@code true} if the category is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the category is not valid.
	 */

}
