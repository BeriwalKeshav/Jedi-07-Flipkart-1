/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
	
	/**
	 * @param uId
	 * @param newpwd
	 * @return
	 */
	public boolean updatePassword(String userName,String newPassword) throws UserNotFoundException;
	
	/**
	 * @param uId
	 * @param pwd
	 * @return
	 */
	public boolean verifyCredentials(String userName,String password) throws UserNotFoundException;
	
	
	/**
	 * @param userName
	 * @return
	 * @throws UserNotFoundException
	 */
	public String getUserRole(String userName) throws UserNotFoundException;
	
	
	
}
