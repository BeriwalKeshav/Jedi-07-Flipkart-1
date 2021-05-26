package com.flipkart.service;

import com.flipkart.dao.UserDAOImpl;
import com.flipkart.dao.UserDAOInterface;
import com.flipkart.exception.UserNotFoundException;

public class UserOperation implements UserInterface{
	
	private static volatile UserOperation instance=null;
	
	UserDAOInterface userDaoImpl = UserDAOImpl.getInstance();
	
	private UserOperation()
	{
		
	}
	
	/**
	 * Method to make UserOperation Singleton
	 * @return
	 */
	public static UserOperation getInstance(){
		
		if(instance==null){
			synchronized(UserOperation.class){
				instance=new UserOperation();
			}
		}
		return instance;
	}
	

	@Override
	public boolean updatePassword(String userName, String newPassword) throws UserNotFoundException {
		return userDaoImpl.updatePassword(userName, newPassword);	
	}

	@Override
	public boolean verifyCredentials(String userName, String password) throws UserNotFoundException {
		return userDaoImpl.verifyCredentials(userName, password);		
		
	}

	@Override
	public String getUserRole(String userName) throws UserNotFoundException {
		return userDaoImpl.getUserRole(userName);	
	}
	
	

}
