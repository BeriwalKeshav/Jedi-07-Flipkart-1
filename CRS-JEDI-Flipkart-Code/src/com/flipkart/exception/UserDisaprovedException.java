/**
 * 
 */
package com.flipkart.exception;

/**
 * @author keshavberiwal
 *
 */
public class UserDisaprovedException extends Exception {
	private String uName;
	

	/**
	 * @param uName
	 */
	public UserDisaprovedException(String uName) {
		this.uName = uName;
	}
	
	/**
	 *
	 */
	public String getMessage() {
		return "User with userId: " + uName + " not Aprooved.";
	}
	
	
	

	
}
