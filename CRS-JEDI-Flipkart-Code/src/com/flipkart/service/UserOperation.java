package com.flipkart.service;

import java.util.UUID;

import com.flipkart.dao.UserDAOImpl;
import com.flipkart.dao.UserDaoInterface;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface{
	
	UserDaoInterface userDaoInterface= new UserDAOImpl();

	@Override
	public boolean resetPassword(String uId, String newpwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyCredentials(String uId, String pwd) throws UserNotFoundException {
		try
		{
			return userDaoInterface.verifyCredentials(uId, pwd);		
		}
		finally
		{
			
		}
		
	}
	
	

}
