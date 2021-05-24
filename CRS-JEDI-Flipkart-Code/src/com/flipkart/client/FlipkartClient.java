/**
 * 
 */
package com.flipkart.client;

import com.flipkart.service.CustomerImpl;
import com.flipkart.service.CustomerInterface;

/**
 * @author lenovo
 *
 */
public class FlipkartClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerInterface customer = new CustomerImpl(); 
		customer.createCustomer();
		customer.deleteCustomer(0);
		customer.listCustomer();
		customer.updateCustomer(0, null);
	}

}
