/**
 * 
 */
package com.flipkart.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.RolesConstant;
import com.flipkart.dao.StudentDAOInterface;
import com.flipkart.dao.StudentDAOOperation;
import com.flipkart.exception.ProfessorAdditionFailedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserNameAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author adityasuraj
 *
 */
public class CRSMainApplication {
	
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
					System.out.println("Exiting Application...");
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
		System.out.println("++++++++++++  CMS  +++++++++++++++");
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
	public void loginUser() {
		
		String userName, password, role = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User Id:");
		userName = sc.next();
		System.out.println("Enter Password:");
		password = sc.next();
		
		try {
			
			loggedIn = userInterface.verifyCredentials(userName, password);
			
			System.out.println("Login Status -> " +  loggedIn);
			
			role = userInterface.getUserRole(userName);
			
			if(loggedIn == false || role == null) {
				System.out.println("++ Login Failed Returning to Main Menu");
				return;
			}
			
			
			switch(RolesConstant.stringToName(role))
			{	
				case STUDENT:
					System.out.println("Student logged in!");
					StudentClientMenu studentMenu=new StudentClientMenu();
					studentMenu.renderMenu(userName);
					break;
				case PROFESSOR:
					System.out.println("Professor logged in!");
					ProfessorClientMenu professorMenu = new ProfessorClientMenu();
					professorMenu.renderMenu(userName);
					break;	
				case ADMIN:
					System.out.println("Admin logged in!");
					AdminClientMenu adminMenu=new AdminClientMenu();
					adminMenu.renderMenu(userName);
					break;
				default:
					System.out.println("Invalid Input");
			}
		
		} catch (UserNotFoundException ex) {
			System.out.println("++ Login Failed Returning to Main Menu");
		}
			
	}
	
	/**
	 * Method to register student
	 * @throws ParseException 
	 */
	public void registerStudent(){
		Scanner scanner = new Scanner(System.in);

		Student student = new Student();
		
		System.out.println("Enter Student User ID:");
		String studentID = scanner.next();
		student.setuId(studentID);
		
		System.out.println("Enter Student User Name:");
		String studentName = scanner.next();
		student.setuName(studentName);

		System.out.println("Enter Student Branch:");
		String branch = scanner.next();
		student.setsBranch(branch);
		
		System.out.println("Enter Student Roll Number:");
		int rollno = scanner.nextInt();
		student.setsRollNo(rollno);
		
		student.setApproved(false);
		
		System.out.println("Enter Student Password:");
		String pwd = scanner.next();
		student.setuPwd(pwd);
		
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			student.setuCrDate(date1);
		}catch(ParseException e){
			System.out.println(e.getMessage());
		}
		
		
		StudentInterface studentOperation = StudentOperation.getInstance();
		
		int flag=0;
		
		try {
			flag = studentOperation.addStudent(student);
		} catch (StudentNotRegisteredException | UserNameAlreadyInUseException e) {
			System.out.println(e.getMessage());
		}
		if(flag==1) {
			System.out.println("Student registered successfully!");
		}
		else {
			System.out.println("Student failed to register.");
		}
	}
	
	/**
	 * Method to update password of the User
	 */
	public void updatePassword() {
		String userName, newPassword, role = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User Id:");
		userName = sc.next();
		System.out.println("Enter New Password:");
		newPassword = sc.next();
		
		try {
			
			boolean isUpdated = userInterface.updatePassword(userName, newPassword);
			if( isUpdated == true) {
				System.out.println("Password changed for User -> " + userName);
			}else {
				System.out.println("+++++++ Password Update Failed");
			}
		
		} catch (UserNotFoundException ex) {
			System.out.println("++ User Not Found");
		}
	}

}
