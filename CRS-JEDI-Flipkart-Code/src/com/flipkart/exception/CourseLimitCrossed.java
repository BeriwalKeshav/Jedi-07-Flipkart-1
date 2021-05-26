/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Administrator
 *
 */
public class CourseLimitCrossed extends Exception {
	private int no;

	/**
	 * @param no
	 */
	public CourseLimitCrossed(int no) {
		this.no = no;
	}

	public String getMessgae() {
		return "Course Registration Limit Exceeded";
	}

}
