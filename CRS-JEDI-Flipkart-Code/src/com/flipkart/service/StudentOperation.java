/**
 * 
 */
package com.flipkart.service;

import java.util.UUID;

import com.flipkart.exception.StudentNotRegisteredException;

import com.flipkart.bean.Student;
//import com.flipkart.client.CRSApplication;
//import com.flipkart.constant.Gender;
//import com.flipkart.constant.Role;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperation;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author JEDI-7
 *
 */
public class StudentOperation implements StudentInterface {

	private static volatile StudentOperation instance=null;
	
	StudentDAOInterface studentDaoInterface = StudentDAOOperation.getInstance();
	
	private StudentOperation()
	{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}
	
	@Override
	public int register(String uname, UUID uID, String uPwd, String sBranch, int sRollNo)
			throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStudentId(UUID uId) {
		// TODO Auto-generated method stub
		return studentDaoInterface.getStudentId(uId.toString());
	}

	@Override
	public boolean isApproved(String sId) {
		// TODO Auto-generated method stub
		return studentDaoInterface.isApproved(sId);
	}

}
