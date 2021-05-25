/**
 * 
 */
package com.flipkart.service;

import java.util.UUID;

/**
 * @author vibhorkansal
 *
 */
public interface StudentInterface{
	
	
	
	/**
	 * @param uname
	 * @param uID
	 * @param uPwd
	 * @param sBranch
	 * @param sRoll
	 * @return
	 */
	public int register(String uname,UUID uID,String uPwd,String sBranch,int sRollNo);
	
	/**
	 * @param uId
	 * @return
	 */
	public int getStudentId(UUID uId);
	
    	
	/**
	 * @param sId
	 * @return
	 */
	public boolean isApproved(int sId);
}
