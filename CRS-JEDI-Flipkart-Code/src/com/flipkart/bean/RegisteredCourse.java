/**
 * 
 */
package com.flipkart.bean;

/**
 * @author vibhorkansal
 *
 */
public class RegisteredCourse {
	private String cCode;
	private int sRollNo;
	private int sem;
	private Grade grade;
	
	/**
	 * @param cCode
	 * @param sRollNo
	 * @param sem
	 * @param grade
	 */
	public RegisteredCourse(String cCode, int sRollNo, int sem, Grade grade) {
		super();
		this.cCode = cCode;
		this.sRollNo = sRollNo;
		this.sem = sem;
		this.grade = grade;
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
	 * @return the sRollNo
	 */
	public int getsRollNo() {
		return sRollNo;
	}
	/**
	 * @param sRollNo the sRollNo to set
	 */
	public void setsRollNo(int sRollNo) {
		this.sRollNo = sRollNo;
	}
	/**
	 * @return the sem
	 */
	public int getSem() {
		return sem;
	}
	/**
	 * @param sem the sem to set
	 */
	public void setSem(int sem) {
		this.sem = sem;
	}
	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}
