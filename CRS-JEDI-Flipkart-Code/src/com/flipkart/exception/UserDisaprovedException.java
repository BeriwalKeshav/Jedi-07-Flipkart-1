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
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}



	/**
	 * @param uName
	 */
	public UserDisaprovedException(String uName) {
		this.uName = uName;
	}
	
	
	

	
}
