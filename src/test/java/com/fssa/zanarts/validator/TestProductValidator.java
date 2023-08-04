package com.fssa.zanarts.validator;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.CustomExpection;

import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

public class TestProductValidator {

//	valid testcase for productvalidator
	@Test
	public void testValidate() throws CustomExpection {
		try {
			Dimension dm = new Dimension(100, 100);

			Product product = new Product();
			product.setArtistname("Santhanam");
			product.setId(1);
			product.setPrice(200.0);
			product.setCategory("MANDANA");
			product.setSize(dm);
			product.setProductDescription("Santhanam is my frist art");
			product.setUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg");
			product.setUploadTime(null);
			product.setProductname("Hello");

			ProductValidator productvalidator = new ProductValidator();
			Assertions.assertTrue(productvalidator.validate(product));
		} catch (CustomExpection ex) {
			ex.getMessage();
		}
	}

//	invalid testcase for productvalidator

	@Test
	public void inValidTestValidate() {
		ProductValidator productValidator = new ProductValidator();
		try {
			productValidator.validate(null);
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_OBJECT_NULL, ex.getMessage());
		}

	}

//	Validate testcase for productName
	@Test
	public void testValidProductName() {

		try {
			Assertions.assertTrue(ProductValidator.validateName("Santhanam"));
		} catch (CustomExpection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	invalid testcase  null exception for Productname 

	@Test
	public void testInValiateNullProductName() {

		try {
			ProductValidator.validateName(null);
			Assertions.fail("Validation name failed");
		}

		catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTNAME_NULL, ex.getMessage());
		}
	}

//invalid test case invalid product name

	@Test
	public void testInvalidatelengthProductName() {
		try {
			ProductValidator.validateName("s");

			Assertions.fail("Validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_LENGTH_PRODUCT_NAME, ex.getMessage());
		}
	}

//	valid testcase for product id 
	@Test
	public void testvalidProductId() {

		try {
			Assertions.assertTrue(ProductValidator.validateProductId(1));
		} catch (CustomExpection ex) {
			ex.printStackTrace();
		}

	}

//	invalid testcase for product id
	@Test
	public void testInvalidProductId() {
		try {
			ProductValidator.validateProductId(0);
			Assertions.fail("ProductId validation failed");
		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTID, ex.getMessage());
		}
	}

//	Validate testcase for Artist
	@Test
	public void testValidArtistName() {

		try {
			Assertions.assertTrue(ProductValidator.validateArtistName("Santhanam"));
		} catch (CustomExpection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// invalid test case invalid Artist name

	@Test
	public void testInvalidateArtistName() {
		try {
			ProductValidator.validateArtistName(null);

			Assertions.fail("Validation Artist name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_ARTISTNAME_NULL, ex.getMessage());
		}
	}

	// invalid test case invalid Artist name

	@Test
	public void testInvalidatelengthArtistName() {
		try {
			ProductValidator.validateArtistName("s");

			Assertions.fail("Validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_ARTIST_NAME, ex.getMessage());
		}
	}

//	validation for valid Description
	@Test

	public void testValidDescription() {
		try {
			Assertions.assertTrue(ProductValidator.validateDescription("santhanamkjbvdfvknfbflks"));
		} catch (CustomExpection e) {
			e.getMessage();
		}

	}

//	invalid validator for description

	@Test
	public void testInValidNullDescription() {
		try {
			ProductValidator.validateDescription(null);

			Assertions.fail(" Description validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_DESCRIPTION_NULL, ex.getMessage());
		}
	}

//	invalid validator for description

	@Test
	public void testInValidLengthDescription() {
		try {
			ProductValidator.validateDescription("df");

			Assertions.fail("Description validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_DESCRIPTION, ex.getMessage());
		}
	}

//valid testcase for price

	@Test
	public void testValidprice() throws CustomExpection {
		Assertions.assertTrue(ProductValidator.validatePrice(300));
	}

//	invalid testcase for price
	@Test
	public void testInvalidprice() {
		try {
			ProductValidator.validatePrice(-1);
			Assertions.fail("Price validation failed");
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRICE, ex.getMessage());
		}
	}

//valid Testcase for url
	@Test
	public void testvalidurl() throws CustomExpection {
		Assertions.assertTrue(ProductValidator.validateurl(
				"https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/udHvbKwV-IMG-Dubai-UAE-1-1200x800.jpg"));
	}

//	invalid Testcase for url
	@Test
	public void testInvalidateNullUrl() {
		try {
			ProductValidator.validateurl(null);

			Assertions.fail("Validation Url failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_NULL_URL, ex.getMessage());
		}
	}

//	invalid Testcase for url
	@Test
	public void testInvalidateUrl() {
		try {
			Product p = new Product();
			p.setImageurl("vknsdkjvskvsdvwdv");
			ProductValidator.validateurl(p.getImageurl());

			Assertions.fail("Validation Url failed");

		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_URL, ex.getMessage());
		}
	}

//	valid width and height

	@Test
	public void testValidateDimension() throws CustomExpection {
		Dimension dm = new Dimension();
		dm.setHeight(320);
		dm.setWidth(1100);
		Assertions.assertTrue(ProductValidator.validateDimension(dm));
	}

//	invalid width

	@Test
	public void testInvalidateDimensionWidth() throws CustomExpection {

		try {
			Dimension dm = new Dimension();
			dm.setHeight(320);
			dm.setWidth(0);
			ProductValidator.validateDimension(dm);
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_WIDTH_AND_HEIGHT, ex.getMessage());
		}

	}

//	invalid height

	@Test
	public void testInvalidateDimensionHeight() throws CustomExpection {

		try {
			Dimension dm = new Dimension();
			dm.setHeight(0);
			dm.setWidth(520);
			ProductValidator.validateDimension(dm);
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_WIDTH_AND_HEIGHT, ex.getMessage());
		}

	}

//valid enum

	@Test
	public void testValidEnum() throws CustomExpection {

		Product p = new Product();
		p.setCategory("SKETCH");
		Assertions.assertTrue(ProductValidator.validCategory(p.getCategory()));

	}

//	invalid enum
	@Test
	public void testInValidEnum() throws CustomExpection {

		try {

			ProductValidator.validCategory("not");
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_ENUM, ex.getMessage());
		}

	}

//	valid testcase
	@Test
	public void testDateAndTest() {
		Product product = new Product();
		product.setUploadTime(LocalDateTime.now());
		LocalDateTime nowDate = product.getUploadTime();
		Assertions.assertEquals(nowDate, LocalDateTime.now());
	}

}