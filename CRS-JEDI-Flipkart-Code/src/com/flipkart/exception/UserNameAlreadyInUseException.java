/**
 * 
 */
package com.flipkart.exception;

/**
 * @author adityasuraj
 *
 */
public class UserNameAlreadyInUseException extends Exception{
	private String uName;
	
	
	public UserNameAlreadyInUseException(String uName) {
		this.uName = uName;
	}
	
	public String getUName() {
		return uName;
	}
	
	@Override
	public String getMessage() {
		return "userName: " + uName + " is already in use.";
	}
}
