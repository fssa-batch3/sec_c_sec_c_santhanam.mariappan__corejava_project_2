package com.fssa.zanarts.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.CustomExpection;
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
	public static boolean validate(Product product) throws CustomExpection {

		if (product==null) {
			throw new CustomExpection(CustomErrors.INVALID_OBJECT_NULL);
		}

		validateName(product.getProductname());
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
	 * @param productname The name of the product.
	 * @return {@code true} if the name is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the name is not valid.
	 */
	public static boolean validateName(String productName) throws CustomExpection {

		if (productName == null || "".equals(productName.trim())) {
			throw new CustomExpection(CustomErrors.INVALID_PRODUCTNAME_NULL);
		}

		String nameregex = "^[A-Za-z]{5,20}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productName);
		Boolean isMatch = matcher.matches();

		if (!isMatch)
			throw new CustomExpection(CustomErrors.INVALID_LENGTH_PRODUCT_NAME);

		return true;
	}

	/** 
	 * Validates a product ID.
	 *
	 * @param id The ID of the product.
	 * @return {@code true} if the ID is valid, otherwise throws a CustomException.
	 * @throws CustomExpection If the ID is not valid.
	 */
	public static boolean validateProductId(int id) throws CustomExpection {

		if (id <= 0) {
			throw new CustomExpection(CustomErrors.INVALID_PRODUCTID);
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
	public static boolean validateArtistName(String artistName) throws CustomExpection {

		if (artistName == null || "".equals(artistName.trim())) { //"".equals(productname.trim())
			throw new CustomExpection(CustomErrors.INVALID_ARTISTNAME_NULL);
		}

		String nameregex = "^[A-Za-z ]{3,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(artistName);
		Boolean isMatch = matcher.matches();

		if (isMatch)
			return true;

		throw new CustomExpection(CustomErrors.INVALID_ARTIST_NAME);

	}

	/**
	 * Validates a product description.
	 *
	 * @param description The description of the product.
	 * @return {@code true} if the description is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the description is not valid.
	 */
	public static boolean validateDescription(String description) throws CustomExpection {

		if (description == null || "".equals(description.trim())) {
			throw new CustomExpection(CustomErrors.INVALID_DESCRIPTION_NULL);
		}

		String regex = "^[A-Za-z ]{5,100}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(description);
		Boolean isMatch = matcher.matches();
		if (isMatch) {
			return true;
		}

		throw new CustomExpection(CustomErrors.INVALID_DESCRIPTION);

	}

	/**
	 * Validates a product price.
	 *
	 * @param price The price of the product.
	 * @return {@code true} if the price is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the price is not valid.
	 */
	public static boolean validatePrice(double price) throws CustomExpection {
		if (price <= 0) {
			throw new CustomExpection(CustomErrors.INVALID_PRICE);
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
	public static boolean validateurl(String url) throws CustomExpection {
		if (url == null || "".equals(url.trim())) {
			throw new CustomExpection(CustomErrors.INVALID_NULL_URL);

		}

		String urlregex = "^(http|https)://.*\\.(jpg|jpeg|png|gif)$";

		Pattern pattern = Pattern.compile(urlregex);
		Matcher matcher = pattern.matcher(url);
		Boolean isMatch = matcher.matches();

		if (isMatch) {
			return true;
		}
		throw new CustomExpection(CustomErrors.INVALID_URL);
	}

	/**
	 * Validates a Dimension object.
	 *
	 * @param dm The Dimension object to validate.
	 * @return {@code true} if the Dimension is valid, otherwise throws a
	 *         CustomException.
	 * @throws CustomExpection If the Dimension is not valid.
	 */

	public static boolean validateDimension(Dimension dm) throws CustomExpection {

		if (dm.getHeight() <= 300 || dm.getHeight() >= 700) {
			throw new CustomExpection(CustomErrors.INVALID_WIDTH_AND_HEIGHT);
		}

		if (dm.getWidth() <= 500 || dm.getWidth() >= 1200) {
			throw new CustomExpection(CustomErrors.INVALID_WIDTH_AND_HEIGHT);
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
//	public static boolean validCategory(String types) throws CustomExpection {
//		for (Types enumValue : Types.values()) {
//			if (enumValue.name().equalsIgnoreCase(types)) {
//				return true;
//			}
//		}
//		throw new CustomExpection(CustomErrors.INVALID_ENUM);
//
//	}

}
