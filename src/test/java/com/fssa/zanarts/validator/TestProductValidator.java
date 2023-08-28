package com.fssa.zanarts.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.zanarts.customexception.CustomErrors;
import com.fssa.zanarts.customexception.ProductExpection;
import com.fssa.zanarts.enumclass.Types;
import com.fssa.zanarts.model.Dimension;
import com.fssa.zanarts.model.Product;

/**
 * Test class for ProductValidator with various test cases.
 */
class TestProductValidator {
	/**
	 * Valid test case for validating a product.
	 *
	 * @throws CustomExpection If validation fails.
	 */

	@Test
	void testValidate() throws ProductExpection {
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
			product.setname("Hello");

			ProductValidator productvalidator = new ProductValidator();
			Assertions.assertTrue(productvalidator.validate(product));
		} catch (ProductExpection ex) {
			ex.getMessage();
		}
	}

	// ...

	/**
	 * Invalid test case for validating a null product.
	 */

	@Test
	void inValidTestValidate() {
		ProductValidator productValidator = new ProductValidator();
		try {
			productValidator.validate(null);
		} catch (ProductExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_OBJECT_NULL, ex.getMessage());
		}

	}

	/**
	 * Valid test case for product name validation.
	 */
	@Test
	void testValidProductName() {

		try {
			Assertions.assertTrue(ProductValidator.validateName("Santhanam"));
		} catch (ProductExpection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Invalid test case for null product name validation.
	 */

	@Test
	void testInValiateNullProductName() {

		try {
			ProductValidator.validateName(null);
			Assertions.fail("Validation name failed");
		}

		catch (ProductExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTNAME_NULL, ex.getMessage());
		}
	}

	/**
	 * Invalid test case for invalid product name length.
	 */

	@Test
	void testInvalidatelengthProductName() {
		try {
			ProductValidator.validateName("s");

			Assertions.fail("Validation name failed");

		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_LENGTH_PRODUCT_NAME, ex.getMessage());
		}
	}

	/**
	 * Valid test case for product ID validation.
	 */
	@Test
	void testvalidProductId() {

		try {
			Assertions.assertTrue(ProductValidator.validateProductId(1));
		} catch (ProductExpection ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Valid test case for Invalidproduct id
	 */
	@Test
	void testInvalidProductId() {
		try {
			ProductValidator.validateProductId(0);
			Assertions.fail("ProductId validation failed");
		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_PRODUCTID, ex.getMessage());
		}
	}

	/**
	 * Invalid test case for invalid product ID validation.
	 */
	@Test
	 void testValidArtistName() {

		try {
			Assertions.assertTrue(ProductValidator.validateArtistName("Santhanam"));
		} catch (ProductExpection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Invalid test case invalid Artist name
	 */

	@Test
	 void testInvalidateArtistName() {
		try {
			ProductValidator.validateArtistName(null);

			Assertions.fail("Validation Artist name failed");

		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_ARTISTNAME_NULL, ex.getMessage());
		}
	}

	/*
	 * Invalid test case invalid Artist name
	 * 
	 */
	@Test
	  void testInvalidatelengthArtistName() {
		try {
			ProductValidator.validateArtistName("s");

			Assertions.fail("Validation name failed");

		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_ARTIST_NAME, ex.getMessage());
		}
	}

	/**
	 * Validation for valid Description
	 **/

	@Test

	  void testValidDescription() {
		try {
			Assertions.assertTrue(ProductValidator.validateDescription("santhanamkjbvdfvknfbflks"));
		} catch (ProductExpection e) {
			e.getMessage();
		}

	}

	/*
	 * Invalid validator for Description
	 */

	@Test
	  void testInValidNullDescription() {
		try {
			ProductValidator.validateDescription(null);

			Assertions.fail(" Description validation name failed");

		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_DESCRIPTION_NULL, ex.getMessage());
		}
	}

	/*
	 * Invalid validator for description
	 */

	@Test
	  void testInValidLengthDescription() {
		try {
			ProductValidator.validateDescription("df");

			Assertions.fail("Description validation name failed");

		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_DESCRIPTION, ex.getMessage());
		}
	}

	/*
	 * valid testcase for price
	 */

	@Test
	  void testValidprice() throws ProductExpection {
		Assertions.assertTrue(ProductValidator.validatePrice(300));
	}

	/*
	 * Invalid testcase for price
	 */
	@Test
	void testInvalidprice() {
		try {
			ProductValidator.validatePrice(-1);
			Assertions.fail("Price validation failed");
		} catch (ProductExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_PRICE, ex.getMessage());
		}
	}

	/*
	 * valid Testcase for url
	 */
	@Test
	void testvalidurl() throws ProductExpection {
		Assertions.assertTrue(ProductValidator.validateurl(
				"https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/udHvbKwV-IMG-Dubai-UAE-1-1200x800.jpg"));
	}

	/*
	 * Invalid Testcase for url
	 */
	@Test
	void testInvalidateNullUrl() {
		try {
			ProductValidator.validateurl(null);

			Assertions.fail("Validation Url failed");

		} catch (ProductExpection ex) {

			Assertions.assertEquals(CustomErrors.INVALID_NULL_URL, ex.getMessage());
		}
	}

	/**
	 * Invalid test case for URL validation.
	 */
	@Test
	void testInvalidateUrl() {
		try {
			Product p = new Product();
			p.setImageurl("vknsdkjvskvsdvwdv");
			ProductValidator.validateurl(p.getImageurl());

			Assertions.fail("Validation Url failed");

		} catch (ProductExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_URL, ex.getMessage());
		}
	}

	/**
	 * Valid test case for validating dimension.
	 */

	@Test
	void testValidateDimension() throws ProductExpection {
		Dimension dm = new Dimension();
		dm.setHeight(320);
		dm.setWidth(1100);
		Assertions.assertTrue(ProductValidator.validateDimension(dm));
	}

	/**
	 * Invalid test case for validating dimension width.
	 */

	@Test
	void testInvalidateDimensionWidth() throws ProductExpection {

		try {
			Dimension dm = new Dimension();
			dm.setHeight(320);
			dm.setWidth(0);
			ProductValidator.validateDimension(dm);
		} catch (ProductExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_WIDTH_AND_HEIGHT, ex.getMessage());
		}

	}

	/**
	 * Invalid test case for validating dimension height.
	 */

	@Test
	void testInvalidateDimensionHeight() throws ProductExpection {

		try {
			Dimension dm = new Dimension();
			dm.setHeight(0);
			dm.setWidth(520);
			ProductValidator.validateDimension(dm);
		} catch (ProductExpection ex) {
			Assertions.assertEquals(CustomErrors.INVALID_WIDTH_AND_HEIGHT, ex.getMessage());
		}

	}

	 

}