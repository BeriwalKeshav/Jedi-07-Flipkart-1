/**
 * 
 */
package com.flipkart.client;

import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.constants.RolesConstant;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author adityasuraj
 *
 */
public class CRSMainApplication {
	
	private static Logger logger = Logger.getLogger(CRSMainApplication.class);
	UserInterface userInterface = new UserOperation();
	static boolean loggedIn = false;
	

	/**
	 * @param args
	 * @throws UserNotFoundException 
	 */
	public static void main(String[] args) throws UserNotFoundException {
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		CRSMainApplication app = new CRSMainApplication();
		
		int userInput=0;
		
		while(userInput!=4) {
			createMainMenu();
			userInput = sc.nextInt();
			switch(userInput)
			{	
				case 1:
					app.loginUser();
					break;
				case 2:
					app.registerStudent();
					break;	
				case 3:
					app.updatePassword();
					break;
				case 4:
					logger.info("Exiting Application...");
					break;
				default:
					logger.info("Invalid Input");
			}
		}
		sc.close();

	}
	
	/**
	 * Method to display Main Menu
	 */
	public static void createMainMenu() {
		logger.info("++++++++++++  CMS  +++++++++++++++");
		logger.info("Menu for Course Management System:");
		logger.info("1. Login");
		logger.info("2. Student Registration");
		logger.info("3. Update password");
		logger.info("4. Exit");
		logger.info("Enter user input : ");
	}
	
	/**
	 * Method to login User
	 * @throws UserNotFoundException 
	 */
	public void loginUser() {
		
		String userName, password, role = null;
		
		Scanner sc = new Scanner(System.in);
		
		logger.info("Enter User Id:");
		userName = sc.next();
		logger.info("Enter Password:");
		password = sc.next();
		
		try {
			
			loggedIn = userInterface.verifyCredentials(userName, password);
			
			logger.info("Login Status -> " +  loggedIn);
			
			role = userInterface.getUserRole(userName);
			
			if(loggedIn == false || role == null) {
				logger.info("++ Login Failed Returning to Main Menu");
				return;
			}
			
			
			switch(RolesConstant.stringToName(role))
			{	
				case STUDENT:
					logger.info("Student logged in!");
					StudentClientMenu studentMenu=new StudentClientMenu();
					studentMenu.renderMenu(userName);
					break;
				case PROFESSOR:
					logger.info("Professor logged in!");
					ProfessorClientMenu professorMenu = new ProfessorClientMenu();
					professorMenu.renderMenu(userName);
					break;	
				case ADMIN:
					logger.info("Admin logged in!");
					AdminClientMenu adminMenu=new AdminClientMenu();
					adminMenu.renderMenu(userName);
					break;
				default:
					logger.info("Invalid Input");
			}
		
		} catch (UserNotFoundException ex) {
			logger.info("++ Login Failed Returning to Main Menu");
		}
			
	}
	
	/**
	 * Method to register student
	 */
	public void registerStudent() {
		logger.info("Student has been registered.");
	}
	
	/**
	 * Method to update password of the User
	 */
	public void updatePassword() {
		String userName, newPassword, role = null;
		
		Scanner sc = new Scanner(System.in);
		
		logger.info("Enter User Id:");
		userName = sc.next();
		logger.info("Enter New Password:");
		newPassword = sc.next();
		
		try {
			
			boolean isUpdated = userInterface.updatePassword(userName, newPassword);
			if( isUpdated == true) {
				logger.info("Password changed for User -> " + userName);
			}else {
				logger.info("+++++++ Password Update Failed");
			}
		
		} catch (UserNotFoundException ex) {
			logger.info("++ User Not Found");
		}
	}

}
