/**
 * 
 */
package com.practice.bean;

/**
 * @author lenovo
 *
 */

// SImple Java Bean Class containing getter and setter.
public class Customer {

	private int custId;
	private String custName;
	private String custAddress;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	
	
}
