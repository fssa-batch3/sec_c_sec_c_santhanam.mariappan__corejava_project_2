package com.fssa.zanarts.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.CustomExpection;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;
import com.fssa.zanarts.model.Product.Types;

public class ProductValidator {

//	validator for object
	public static boolean validate(Product product) throws CustomExpection {

		if (product == null) {
			throw new CustomExpection(CustomErrors.INVALID_OBJECT_NULL);
		}

		validateName(product.getProductname());
		validateProductId(product.getId());
		validateArtistName(product.getArtistname());
		validateDescription(product.getProductDescription());
		validatePrice(product.getPrice());
		validateurl(product.getUrl());
//		validateDimension(product.getSize());
		validCategory(product.getCategory());
		
		return true;


	}

//	validator for product name
	public static boolean validateName(String productname) throws CustomExpection {

		if (productname == null || "".equals(productname.trim())) {
			throw new CustomExpection(CustomErrors.INVALID_PRODUCTNAME_NULL);
		}

		String nameregex = "^[A-Za-z]{5,20}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(productname);
		Boolean isMatch = matcher.matches();

		if (!isMatch)
			throw new CustomExpection(CustomErrors.INVALID_LENGTH_PRODUCT_NAME);

		return true;
	}

//	valdiation for product id
	public static boolean validateProductId(int id) throws CustomExpection {

		if (id <= 0) {
			throw new CustomExpection(CustomErrors.INVALID_PRODUCTID);
		}

		return true;

	}

//	validator for Artist name
	public static boolean validateArtistName(String Artistname) throws CustomExpection {

		if (Artistname == null || Artistname.trim() == " ") {
			throw new CustomExpection(CustomErrors.INVALID_ARTISTNAME_NULL);
		}

		String nameregex = "^[A-Za-z ]{3,30}$";
		Pattern pattern = Pattern.compile(nameregex);
		Matcher matcher = pattern.matcher(Artistname);
		Boolean isMatch = matcher.matches();

		if (isMatch)
			return true;

		throw new CustomExpection(CustomErrors.INVALID_ARTIST_NAME);

	}

//	validate the  Description
	public static boolean validateDescription(String Description) throws CustomExpection {

		if (Description == null || "".equals(Description.trim())) {
			throw new CustomExpection(CustomErrors.INVALID_DESCRIPTION_NULL);
		}

		String regex = "^[A-Za-z ]{5,100}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(Description);
		Boolean isMatch = matcher.matches();
		if (isMatch) {
			return true;
		}

		throw new CustomExpection(CustomErrors.INVALID_DESCRIPTION);

	}

//	validation for prize
	public static boolean validatePrice(double price) throws CustomExpection {
		if (price <= 0) {
			throw new CustomExpection(CustomErrors.INVALID_PRICE);
		}
		return true;
	}

//	validation for Url
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

	public static boolean validateDimension(Dimension dm) throws CustomExpection {

		if (dm.getHeight() <= 300 || dm.getHeight() >= 700) {
			throw new CustomExpection(CustomErrors.INVALID_WIDTH_AND_HEIGHT);
		}

		if (dm.getWidth() <= 500 || dm.getWidth() >= 1200) {
			throw new CustomExpection(CustomErrors.INVALID_WIDTH_AND_HEIGHT);
		}

		return true;

	}

//	for enum
	public static boolean validCategory(String types) throws CustomExpection {
		for (Types enumValue : Types.values()) {
			if (enumValue.name().equalsIgnoreCase(types)) {
				return true;
			}
		}
		throw new CustomExpection(CustomErrors.INVALID_ENUM);

	}

}
