/**
 * 
 */
package com.flipkart.exception;

/**Exception to check if seat is available in a course or not
 * @author prafu
 *
 */
public class SeatNotAvailableException extends Exception{
	private Strign cCode;

	/**
	 * @param cCode
	 */
	public SeatNotAvailableException(Strign cCode) {
		this.cCode = cCode;
	}

	/**
	 * @return the cCode
	 */
	public Strign getcCode() {
		return cCode;
	}
	

}
