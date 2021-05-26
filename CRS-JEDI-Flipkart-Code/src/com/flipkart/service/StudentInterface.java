/**
 * 
 */
package com.flipkart.service;

import java.util.UUID;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserNameAlreadyInUseException;


public interface StudentInterface{
	
	
	
	/**
	 * @param uname
	 * @param uID
	 * @param uPwd
	 * @param sBranch
	 * @param sRoll
	 * @return
	 */
	public int addStudent(Student student) throws StudentNotRegisteredException, UserNameAlreadyInUseException;
	
	/**
	 * @param uId
	 * @return
	 */
	public String getStudentId(UUID uId);
	
    	
	/**
	 * @param sId
	 * @return
	 */
	public boolean isApproved(String sId);
}
