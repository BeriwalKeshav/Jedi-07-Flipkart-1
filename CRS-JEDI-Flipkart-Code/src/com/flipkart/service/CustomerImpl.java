/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Customer;

/**
 * @author lenovo
 *
 */
public class CustomerImpl implements CustomerInterface {

	@Override
	public void createCustomer() {
		
		System.out.println("Create Customer");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listCustomer() {
		System.out.println("List Customer");

		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteCustomer(int custId) {
		System.out.println("Delete Customer by Id");

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(int custId, Customer cust) {
		// TODO Auto-generated method stub
		System.out.println("update Customer");
		return false;
	}
	
	

}
