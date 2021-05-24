/**
 * 
 */
package com.flipkart.client;

import java.util.*;

/**
 * @author adityasuraj
 *
 */
public class CRSMainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
	 */
	public void loginUser() {
		System.out.println("Enter user number:");
		System.out.println("1. Student");
		System.out.println("2. Professor");
		System.out.println("3. Admin");
		Scanner sc = new Scanner(System.in);
		int userInput;
		userInput = sc.nextInt();
		switch(userInput)
		{	
			case 1:
				System.out.println("Student logged in!");
				break;
			case 2:
				System.out.println("Professor logged in!");
				break;	
			case 3:
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
