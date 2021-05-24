/**
 * 
 */
package com.flipkart.service;

import java.util.UUID;

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
	boolean resetPassword(UUID uId,String newpwd);
	
	/**
	 * @param uId
	 * @param pwd
	 * @return
	 */
	public boolean verifyCredentials(UUID uId,String pwd);
	
	
	
}
