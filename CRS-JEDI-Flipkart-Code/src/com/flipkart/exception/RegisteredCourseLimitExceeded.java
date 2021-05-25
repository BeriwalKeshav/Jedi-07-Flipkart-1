/**
 * 
 */
package com.flipkart.exception;

/**
 * @author adityasuraj
 *
 */
public class RegisteredCourseLimitExceeded extends Exception {
	private int numCourses;

	/**
	 * Constructor
	 * @param numCourses number of courses
 	 */
	public RegisteredCourseLimitExceeded(int numCourses )
	{	
		this.numCourses = numCourses;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "You have already registered in " + numCourses + " courses";
	}
}
