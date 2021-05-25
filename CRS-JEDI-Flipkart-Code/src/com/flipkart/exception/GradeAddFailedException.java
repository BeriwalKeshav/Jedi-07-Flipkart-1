/**
 * 
 */
package com.flipkart.exception;

/**Exceptions to check if grade has been added student's course 
 * @author prafu
 *
 */
public class GradeAddFailedException extends Exception{
	
	private int sRollNo;

	/**
	 * @param sRollNo
	 */
	public GradeAddFailedException(int sRollNo) {
		this.sRollNo = sRollNo;
	}

	/**
	 * @return the sRollNo
	 */
	public int getRollNo() {
		return sRollNo;
	}
	
	@Override
	public String getMessage() {
		return "Can not add Grade for sRollNo: " + sRollNo;
	}
	

}
