/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI Group 7
 *
 */
public class StudentNotFoundForApprovalException extends Exception{	
	private int studentID;
	
	public void StudentNotFoundApprovalException(int studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * Getter function for studentId
	 * @return
	 */
	public int getStudentID() {
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
