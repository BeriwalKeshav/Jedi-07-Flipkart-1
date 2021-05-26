/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-07
 *
 */
public class StudentNotRegisteredException extends Exception{

	private String userName;
	
	public StudentNotRegisteredException(String userName) {
		this.userName = userName;
	}
	
	 /**
	  * getter function for studentName
	  * @return String
	  */
	
	public String getStudentName() {
		return this.userName;
	}
	
	@Override
	public String getMessage() {
		return "Can not add student " + userName + " to database";
	}
	
}
