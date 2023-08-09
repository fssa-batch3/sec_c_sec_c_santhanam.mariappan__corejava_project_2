package com.fssa.zanarts.validator;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.CustomExpection;

import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;
import com.fssa.zanarts.model.Types;

/**
 * Test class for ProductValidator with various test cases.
 */
public class TestProductValidator {
	/**
	 * Valid test case for validating a product.
	 *
	 * @throws CustomExpection If validation fails.
	 */

	@Test
	public void testValidate() throws CustomExpection {
		try {
			Dimension dm = new Dimension(100, 100);

			Product product = new Product();
			product.setArtistname("Santhanam");
			product.setId(1);
			product.setPrice(200.0);
			product.setCategory(Types.MANDANA);
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

	// ...

	/**
	 * Invalid test case for validating a null product.
	 */

	@Test
	public void inValidTestValidate() {
		ProductValidator productValidator = new ProductValidator();
		try {
			productValidator.validate(null);
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_OBJECT_NULL, ex.getMessage());
		}

	}

	/**
	 * Valid test case for product name validation.
	 */
	@Test
	public void testValidProductName() {

		try {
			Assertions.assertTrue(ProductValidator.validateName("Santhanam"));
		} catch (CustomExpection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Invalid test case for null product name validation.
	 */

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

	/**
	 * Invalid test case for invalid product name length.
	 */

	@Test
	public void testInvalidatelengthProductName() {
		try {
			ProductValidator.validateName("s");

			Assertions.fail("Validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_LENGTH_PRODUCT_NAME, ex.getMessage());
		}
	}

	/**
	 * Valid test case for product ID validation.
	 */
	@Test
	public void testvalidProductId() {

		try {
			Assertions.assertTrue(ProductValidator.validateProductId(1));
		} catch (CustomExpection ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Valid test case for Invalidproduct id
	 */
	@Test
	public void testInvalidProductId() {
		try {
			ProductValidator.validateProductId(0);
			Assertions.fail("ProductId validation failed");
		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTID, ex.getMessage());
		}
	}

	/**
	 * Invalid test case for invalid product ID validation.
	 */
	@Test
	public void testValidArtistName() {

		try {
			Assertions.assertTrue(ProductValidator.validateArtistName("Santhanam"));
		} catch (CustomExpection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Invalid test case invalid Artist name
	 */

	@Test
	public void testInvalidateArtistName() {
		try {
			ProductValidator.validateArtistName(null);

			Assertions.fail("Validation Artist name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_ARTISTNAME_NULL, ex.getMessage());
		}
	}

	/*
	 * Invalid test case invalid Artist name
	 * 
	 */
	@Test
	public void testInvalidatelengthArtistName() {
		try {
			ProductValidator.validateArtistName("s");

			Assertions.fail("Validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_ARTIST_NAME, ex.getMessage());
		}
	}

	/**
	 * Validation for valid Description
	 **/

	@Test

	public void testValidDescription() {
		try {
			Assertions.assertTrue(ProductValidator.validateDescription("santhanamkjbvdfvknfbflks"));
		} catch (CustomExpection e) {
			e.getMessage();
		}

	}

	/*
	 * Invalid validator for Description
	 */

	@Test
	public void testInValidNullDescription() {
		try {
			ProductValidator.validateDescription(null);

			Assertions.fail(" Description validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_DESCRIPTION_NULL, ex.getMessage());
		}
	}

	/*
	 * Invalid validator for description
	 */

	@Test
	public void testInValidLengthDescription() {
		try {
			ProductValidator.validateDescription("df");

			Assertions.fail("Description validation name failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_DESCRIPTION, ex.getMessage());
		}
	}

	/*
	 * valid testcase for price
	 */

	@Test
	public void testValidprice() throws CustomExpection {
		Assertions.assertTrue(ProductValidator.validatePrice(300));
	}

	/*
	 * Invalid testcase for price
	 */
	@Test
	public void testInvalidprice() {
		try {
			ProductValidator.validatePrice(-1);
			Assertions.fail("Price validation failed");
		} catch (CustomExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRICE, ex.getMessage());
		}
	}

	/*
	 * valid Testcase for url
	 */
	@Test
	public void testvalidurl() throws CustomExpection {
		Assertions.assertTrue(ProductValidator.validateurl(
				"https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/udHvbKwV-IMG-Dubai-UAE-1-1200x800.jpg"));
	}

	/*
	 * Invalid Testcase for url
	 */
	@Test
	public void testInvalidateNullUrl() {
		try {
			ProductValidator.validateurl(null);

			Assertions.fail("Validation Url failed");

		} catch (CustomExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_NULL_URL, ex.getMessage());
		}
	}

	/**
	 * Invalid test case for URL validation.
	 */
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

	/**
	 * Valid test case for validating dimension.
	 */

	@Test
	public void testValidateDimension() throws CustomExpection {
		Dimension dm = new Dimension();
		dm.setHeight(320);
		dm.setWidth(1100);
		Assertions.assertTrue(ProductValidator.validateDimension(dm));
	}

	/**
	 * Invalid test case for validating dimension width.
	 */

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

	/**
	 * Invalid test case for validating dimension height.
	 */

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

	/**
	 * Valid test case for validating product category.
	 */

//	@Test
//	public void testValidEnum() throws CustomExpection {
//
//		Product p = new Product();
//		p.setCategory(Types.SKETCH);
//		Assertions.assertTrue(ProductValidator.validCategory(p.getCategory()));
//
//	}
//
//	/**
//	 * Invalid test case for invalidating product category.
//	 */
//	@Test
//	public void testInValidEnum() throws CustomExpection {
//
//		try {
//
//			ProductValidator.validCategory("not");
//		} catch (CustomExpection ex) {
//			Assertions.assertEquals(CustomErrors.INVALID_ENUM, ex.getMessage());
//		}
//
//	}

//	valid testcase
//	@Test
//	public void testDateAndTest() {
//		Product product = new Product();
//		product.setUploadTime(LocalDateTime.now());
//		LocalDateTime nowDate = product.getUploadTime();
//		Assertions.assertEquals(nowDate, LocalDateTime.now());
//	}

}