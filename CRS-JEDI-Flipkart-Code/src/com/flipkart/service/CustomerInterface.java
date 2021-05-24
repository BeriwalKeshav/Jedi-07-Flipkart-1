/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Customer;

/**
 * @author lenovo
 *
 */
public interface CustomerInterface {
	
	// Declaration of all services in the interface.
	public void createCustomer();
	
	public void listCustomer();
	
	public boolean deleteCustomer(int custId);
	
	public boolean updateCustomer(int custId,Customer cust);
	
}
