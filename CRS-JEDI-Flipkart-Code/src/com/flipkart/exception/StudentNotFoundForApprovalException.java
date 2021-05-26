/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI Group 7
 *
 */
public class StudentNotFoundForApprovalException extends Exception{	
	private String studentID;
	
	public StudentNotFoundForApprovalException(String studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * Getter function for studentId
	 * @return
	 */
	public String getStudentID() {
		return this.studentID;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	
	@Override
	public String getMessage() {
		return "Student id: " + this.studentID + " not found for approval";
	}
}
