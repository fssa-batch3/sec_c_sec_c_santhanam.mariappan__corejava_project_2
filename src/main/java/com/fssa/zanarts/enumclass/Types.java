package com.fssa.zanarts.enumclass;

import java.util.HashMap;

/**
 * Enumeration representing different types of art.
 */
public enum Types {
	/**
	 * Mandana art type.
	 */
	MANDANA("mandana"),

	/**
	 * Watercolor art type.
	 */
	WATERCOLOUR("watercolour"),

	/**
	 * Sketch art type.
	 */
	SKETCH("sketch"),

	/**
	 * Realism art type.
	 */
	REALISM("realism"),

	/**
	 * Hyperrealism art type.
	 */
	HYPERREALISM("hyperrealism"),

	OILPAINTING("oilpainting"),

	ILLUSTRATION("illustration"),

	PHOTOGRAPHY("photography"),

	DIGITAL("digital"),

	POPART("popart"),

	MODERNPAINTING("modernpainting");

	String value;

	// Constructor to initialize the enum constants with values
	Types(String value) {
		this.value = value;
	}

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	};

	/**
	 * Get the name of the art type.
	 *
	 * @return The name of the art type.
	 */
	public String getTypes() {
		return this.name();
	}

	public static Types valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, Types> valueToEnumMapping = new HashMap<String, Types>();
		System.out.println("value : "+value);
		// Iterate through all BloodGroup enum constants and populate the mapping
		for (Types type : Types.values()) {
			valueToEnumMapping.put(type.getValue(), type);
		}

		// Return the enum constant corresponding to the provided value
		return valueToEnumMapping.get(value);

	}

}

//// Enum constants with their corresponding values
//A_POSITIVE("A+"), A_NEGATIVE("A-"), B_POSITIVE("B+"), B_NEGATIVE("B-"),
//AB_POSITIVE("AB+"), AB_NEGATIVE("AB-"), O_POSITIVE("O+"), O_NEGATIVE("O-");
//
//// Property to store the value of each enum constant
//public final String value;
//
//// Constructor to initialize the enum constants with values
//BloodGroup(String value) {
//    this.value = value;
//}
//
//// Getter method to retrieve the value of the enum constant
//public String getValue() {
// ;
//
//// Static method to map a string value to the corresponding enum constant
//public static BloodGroup valueToEnumMapping(String value) {
//    // Create a mapping of values to enum constants using a HashMap
//    HashMap<String, BloodGroup> valueToEnumMapping = new HashMap<String, BloodGroup>();
//    
//    // Iterate through all BloodGroup enum constants and populate the mapping
//    for (BloodGroup bloodGroup : BloodGroup.values()) {
//        valueToEnumMapping.put(bloodGroup.getValue(), bloodGroup);
//    }
//    
//    // Return the enum constant corresponding to the provided value
//    return valueToEnumMapping.get(value);
//  
//}   return value;
//}
