package com.fssa.zanarts.customexception;

public class CustomErrors {
	private CustomErrors() {

	}

//	Representing the null object error
	public static final String INVALID_OBJECT_NULL = "Object can't be null or empty";

//	Representing the length product name error
	public static final String INVALID_LENGTH_PRODUCT_NAME = "productName length(Character minimum length 3 and maximum length is 100)";

//	Representing the   product name null error	 
	public static final String INVALID_PRODUCTNAME_NULL = "ProductName can't be null or empty";

// 	Product id above zero
	public static final String INVALID_PRODUCTID = "Productid cann't be zero";

//	Representing the length Aretist name error
	public static final String INVALID_ARTIST_NAME = "ArtistName length(Character minimum length 3 and maximum length is 30)";

//	Representing the   product name null error	 
	public static final String INVALID_ARTISTNAME_NULL = "ArtistName can't be null or empty";

//	Representing the   product name null error	 
	public static final String INVALID_DESCRIPTION_NULL = "Description can't be null or empty";

//	Representing the   product name null error	 
	public static final String INVALID_DESCRIPTION = "Description characters manimum 5 characters to 100 characters ";

//	invalid prize
	public static final String INVALID_PRICE = "Prize cann't be below zero";

//	null url
	public static final String INVALID_NULL_URL = "Url cann't be null";

//	invalid url
	public static final String INVALID_URL = "Url Format is invalid";

//	invalid width and height
	public static final String INVALID_WIDTH_AND_HEIGHT = "Width range minimum 500mm to maximum 1200 mm and Height range minimum 300mm to maximum 700mm";

//	invalid error for enum
	public static final String INVALID_ENUM = "Enum can't be null";

//	 Adding product failed sql
	public static final String ADDING_FAILED = "Product Adding Method Is Failed";

//	Update error
	public static final String UPDATE_ERROR = "Product Updating Method Is Failed";

//	sql delete error
	public static final String DELETE_ERROR = "Product Deleting Method Is Failed";

//product details error
	public static final String DETAILS_ERROR = "Get All Product Detail Method Is Failed";

//	user object null
	public static final String USER_NULL = "User cann't br null";

//	user name null
	public static final String USER_NAME_NULL = "Username cann't br null";
//	user name length
	public static final String INVALID_USER_NAME_LENGTH = "Username length minimum 3 to maximum 50";
//	PHONE_NUMBER_NULL
	public static final String PHONE_NUMBER_NULL = "Phone number cann't be null";

//	PHONE_NUMBER_LENGTH
	public static final String PHONE_NUMBER_LENGTH = "Phone number cann't more 10 numbers";

//	password null
	public static final String PASSWORD_NULL = "Password cann't be null";

//	password length 
	public static final String INVALID_PASSWORD_LENGTH = "Password minimum 8 character";

//	invalid email 
	public static final String INVALID_EMAIL = "Email cann't be null";

//	invalid email length
	public static final String INVALID_EMAIL_FORMART = "Email format contain @";
	
//	adding during connnection in user table
	public static final String  ADDING_METHOD_FAIL = "Adding method is failed";
	
//	invalid user id 
	public static final String  INVALID_USER_ID = "User id cann't be zero";
	
//	Update error
	public static final String UPDATE_USER_ERROR = "User Updating Method Is Failed";
 

}
