/**
 * 
 */
package com.flipkart.exception;

/**
 * @author vibhorkansal
 *
 */
public class CourseRegistrationFailedException extends Exception {

	private String cCode;

	/**
	 * Constructor
	 * 
	 * @param courseCode
	 */
	public CourseRegistrationFailedException(String cCode) {
		this.cCode = cCode;
	}

	/**
	 * Getter method
	 * 
	 * @return course code
	 */
	public String getCourseCode() {
		return cCode;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "You have already registered for " + cCode;
	}
}
