/**
 * 
 */
package com.flipkart.exception;

/**
 * @author adityasuraj
 *
 */
public class CourseAlreadyInCatalogException extends Exception {
	
	private String cCode;
	
	/***
	 * Constructor
	 * @param cCode
	 */
	public CourseAlreadyInCatalogException(String cCode) {
		this.cCode = cCode;
	}
	

	/**
	 * Getter method
	 * @return cCode course code
	 */
	public String getCourseCode() {
		return cCode;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Course with cCode: " + cCode + " already present in catalog.";
	}
}
