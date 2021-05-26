/**
 * 
 */
package com.flipkart.bean;

/**
 * @author vibhorkansal
 *
 */
public class Course {
	private String cCode;
	private String cName;
	private boolean isOffered;
	private String ProfName;
	private int NoOfSeats;
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
