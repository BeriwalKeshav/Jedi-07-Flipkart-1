/**
 * 
 */
package com.flipkart.exception;

/**
 * @author keshavberiwal
 *
 */
public class UserNotFoundException extends Exception {
	
	private String uName;

	/**
	 * @param uName
	 */
	public UserNotFoundException(String uName) {
		this.uName = uName;
	}

	/**
	 * Message thrown by exception
	 */
	public String getMessage() {
		return "User with userId: " + uName + " not found.";
	}
	

}
