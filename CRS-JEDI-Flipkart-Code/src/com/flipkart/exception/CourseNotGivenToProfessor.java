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
	 * @return the cCode
	 */
	public String getcCode() {
		return cCode;
	}
	/**
	 * @param cCode the cCode to set
	 */
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	/**
	 * @return the profuName
	 */
	public String getProfuName() {
		return profuName;
	}
	/**
	 * @param profuName the profuName to set
	 */
	public void setProfuName(String profuName) {
		this.profuName = profuName;
	}

	
	/**
	 * @return
	 */
	public String getMessage() {
		return "courseCode: " + cCode + " and professorId: " + profuName + " mismatch!";
	}
	

}
