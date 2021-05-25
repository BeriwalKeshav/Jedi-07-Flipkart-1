/**
 * 
 */
package com.flipkart.exception;

/**Exception to check if seat is available in a course or not
 * @author prafu
 *
 */
public class SeatNotAvailableException extends Exception{
	private String cCode;

	/**
	 * @param cCode
	 */
	public SeatNotAvailableException(String cCode) {
		this.cCode = cCode;
	}

	/**
	 * @return the cCode
	 */
	public String getcCode() {
		return this.cCode;
	}
	
	public String getMessage() {
		return "Seat not available in course " + this.cCode;
	}
	

}
