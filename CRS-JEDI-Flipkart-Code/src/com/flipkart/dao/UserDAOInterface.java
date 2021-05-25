/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author prafu
 *
 */
public interface UserDAOInterface {
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userName,String password) throws UserNotFoundException;
	
	/**
	 * @param userName
	 * @return
	 * @throws UserNotFoundException 
	 */
	public String getUserRole(String userName) throws UserNotFoundException;
	
	
	/**
	 * @param userID
	 * @param newPassword
	 * @return
	 * @throws UserNotFoundException 
	 */
	public boolean updatePassword(String userName, String newPassword) throws UserNotFoundException;

}
