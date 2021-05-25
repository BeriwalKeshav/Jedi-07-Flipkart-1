/**
 * 
 */
package com.flipkart.client;

import java.util.*;

import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author adityasuraj
 *
 */
public class CRSMainApplication {
	
	UserInterface userInterface = new UserOperation();
	static boolean loggedin = false;
	

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
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid Input");
			}
		}
		sc.close();

	}
	
	/**
	 * Method to display Main Menu
	 */
	public static void createMainMenu() {
		
		System.out.println("Menu for Course Management System:");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
		System.out.println("Enter user input");
	}
	
	/**
	 * Method to login User
	 * @throws UserNotFoundException 
	 */
	public void loginUser() throws UserNotFoundException {
		Scanner sc = new Scanner(System.in);
		String userId, password;
		
		System.out.println("Enter User Id:");
		userId = sc.next();
		System.out.println("Enter Password:");
		password = sc.next();
		
		loggedin = userInterface.verifyCredentials(userId, password);
		System.out.println("Login Status -> " +  loggedin);
		
		
		if(loggedin == false) {
			loginUser();
		}
		
		switch("STUDENT")
		{	
			case "STUDENT":
				System.out.println("Student logged in!");
				StudentClientMenu studentMenu=new StudentClientMenu();
				studentMenu.renderMenu(userId);
				break;
			case "PROFESSOR":
				System.out.println("Professor logged in!");
				break;	
			case "ADMIN":
				System.out.println("Admin logged in!");
				break;
			default:
				System.out.println("Invalid Input");
		}
//		sc.close();
			
	}
	
	/**
	 * Method to register student
	 */
	public void registerStudent() {
		System.out.println("Student has been registered.");
	}
	
	/**
	 * Method to update password of the User
	 */
	public void updatePassword() {
		System.out.println("Password has been updated.");
	}

}
