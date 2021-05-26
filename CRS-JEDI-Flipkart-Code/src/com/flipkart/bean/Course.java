/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-7
 *
 */
public class Course {
	/**
	 * @param cCode
	 * @param cName
	 * @param isOffered
	 * @param profName
	 */
	public Course(String cCode, String cName, String profName,boolean isOffered) {
		super();
		this.cCode = cCode;
		this.cName = cName;
		this.isOffered = isOffered;
		ProfName = profName;
	}

	private String cCode;
	private String cName;
	private boolean isOffered;
	private String ProfName;
	private int NoOfSeats;
	/**
	 * @param cCode
	 * @param cname
	 * @param isOffered
	 * @param profName
	 * @param noOfSeats
	 */
	public Course(String cCode, String cname, boolean isOffered, String profName, int noOfSeats) {
		super();
		this.cCode = cCode;
		this.cName = cName;
		this.isOffered = isOffered;
		ProfName = profName;
		NoOfSeats = noOfSeats;
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
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}
	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}
	/**
	 * @return the isOffered
	 */
	public boolean isOffered() {
		return isOffered;
	}
	/**
	 * @param isOffered the isOffered to set
	 */
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	/**
	 * @return the profName
	 */
	public String getProfName() {
		return ProfName;
	}
	/**
	 * @param profName the profName to set
	 */
	public void setProfName(String profName) {
		ProfName = profName;
	}
	/**
	 * @return the noOfSeats
	 */
	public int getNoOfSeats() {
		return NoOfSeats;
	}
	/**
	 * @param noOfSeats the noOfSeats to set
	 */
	public void setNoOfSeats(int noOfSeats) {
		NoOfSeats = noOfSeats;
	}

	
}
