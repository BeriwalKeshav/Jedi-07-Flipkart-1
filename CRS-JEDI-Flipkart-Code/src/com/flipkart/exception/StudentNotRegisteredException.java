/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Harshwardhan Koushik
 *
 */
public class StudentNotRegisteredException extends Exception{

	private String userName;
	
	public void StudentNotRegisteredException(String userName) {
		this.userName = userName;
	}
	
	 /**
	  * getter function for studentName
	  * @return String
	  */
	
	public String getStudentName() {
		return this.userName;
	}
	
}
