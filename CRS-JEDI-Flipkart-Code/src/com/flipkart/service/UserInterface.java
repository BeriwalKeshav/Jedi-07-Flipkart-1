/**
 * 
 */
package com.flipkart.service;

import java.util.UUID;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
	
	/**
	 * @param uId
	 * @param newpwd
	 * @return
	 */
	public boolean resetPassword(String uId,String newpwd);
	
	/**
	 * @param uId
	 * @param pwd
	 * @return
	 */
	public boolean verifyCredentials(String uId,String pwd) throws UserNotFoundException;
	
	
	
}
