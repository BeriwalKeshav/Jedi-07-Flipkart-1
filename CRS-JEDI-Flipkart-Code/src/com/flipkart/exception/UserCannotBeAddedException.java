/**
 * 
 */
package com.flipkart.exception;

/**
 * @author adityasuraj
 *
 */
public class UserCannotBeAddedException extends Exception {
	private String uName;
	
	public UserCannotBeAddedException(String uName) {
		this.uName = uName;
	}
	
	/**
	 * Getter function for uName
	 * @return
	 */
	public String getUName() {
		return this.uName;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "userName: " + uName + " is already in use and hence cannot be added";
	}
}
