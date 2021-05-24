/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;
import java.util.UUID;

/**
 * @author vibhorkansal
 *
 */
public class User {
	private UUID uId;
	private String uName;
	private String uPwd;
	private Date uCrDate;

	/**
	 * @return the uId
	 */
	public UUID getuId() {
		return uId;
	}

	/**
	 * @param uId the uId to set
	 */
	/**
	 * @param uId
	 */
	public void setuId(UUID uId) {
		this.uId = uId;
	}

	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}

	/**
	 * @return the uPwd
	 */
	public String getuPwd() {
		return uPwd;
	}

	/**
	 * @param uPwd the uPwd to set
	 */
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	/**
	 * @return the uCrDate
	 */
	public Date getuCrDate() {
		return uCrDate;
	}

	/**
	 * @param uCrDate the uCrDate to set
	 */
	public void setuCrDate(Date uCrDate) {
		this.uCrDate = uCrDate;
	}

}
