/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ankit
 *
 */
public class CourseNotRemovedException extends Exception{
	private String cCode;
	public CourseNotRemovedException(String cCode)
	{	
		this.cCode = cCode;
	}

	/**
	 * Getter function for course code
	 * @return
	 */
	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + cCode + " can not be removed.";
	}
}
