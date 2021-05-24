/**
 * 
 */
package com.flipkart.bean;

/**
 * @author vibhorkansal
 *
 */
public class Professor extends User {
	private String pDepartment;
	private String pDesignation;

	/**
	 * @return the pDepartment
	 */
	public String getpDepartment() {
		return pDepartment;
	}

	/**
	 * @param pDepartment the pDepartment to set
	 */
	public void setpDepartment(String pDepartment) {
		this.pDepartment = pDepartment;
	}

	/**
	 * @return the pDesignation
	 */
	public String getpDesignation() {
		return pDesignation;
	}

	/**
	 * @param pDesignation the pDesignation to set
	 */
	public void setpDesignation(String pDesignation) {
		this.pDesignation = pDesignation;
	}

}
