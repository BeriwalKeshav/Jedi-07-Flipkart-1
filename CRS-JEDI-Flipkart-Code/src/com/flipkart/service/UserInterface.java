/**
 * 
 */
package com.flipkart.service;

import java.util.UUID;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author vibhorkansal
 *
 */
public interface UserInterface {
	
	/**
	 * @param uId
	 * @param newpwd
	 * @return
	 */
	public boolean resetPassword(UUID uId,String newpwd);
	
	/**
	 * @param uId
	 * @param pwd
	 * @return
	 */
	public boolean verifyCredentials(UUID uId,String pwd) throws UserNotFoundException;
	
	
	
}
