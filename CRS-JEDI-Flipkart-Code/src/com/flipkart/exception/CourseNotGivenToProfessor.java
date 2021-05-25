/**
 * 
 */
package com.flipkart.exception;

/**
 * @author keshavberiwal
 *
 */
public class CourseNotGivenToProfessor extends Exception {
	private String cCode;
	private String profuName;
	
	
	/**
	 * @param cCode
	 * @param profuName
	 */
	public CourseNotGivenToProfessor(String cCode, String profuName) {
		this.cCode = cCode;
		this.profuName = profuName;
	}

	
	/**
	 * @return
	 */
	public String getMessage() {
		return "courseCode: " + cCode + " and professorId: " + profuName + " mismatch!";
	}
	

}
