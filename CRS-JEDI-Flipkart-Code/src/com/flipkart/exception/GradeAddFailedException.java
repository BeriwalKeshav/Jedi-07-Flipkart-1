/**
 * 
 */
package com.flipkart.exception;

/**Exceptions to check if grade has been added student's course 
 * @author prafu
 *
 */
public class GradeAddFailedException extends Exception{
	
	private String sRollNo;

	/**
	 * @param sRollNo
	 */
	public GradeAddFailedException(String sRollNo) {
		this.sRollNo = sRollNo;
	}

	/**
	 * @return the sRollNo
	 */
	public String getRollNo() {
		return sRollNo;
	}
	
	@Override
	public String getMessage() {
		return "Can not add Grade for sRollNo: " + sRollNo;
	}
	

}
