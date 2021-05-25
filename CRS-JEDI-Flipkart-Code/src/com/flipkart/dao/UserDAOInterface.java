/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author prafu
 *
 */
public interface UserDaoInterface {
	
	/**
	 * @param userId
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;

}
