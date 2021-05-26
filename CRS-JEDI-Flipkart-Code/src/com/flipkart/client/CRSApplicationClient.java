/**
 * 
 */
package com.flipkart.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import org.apache.log4j.Logger;

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
public class CRSApplicationClient {
	
	private static Logger logger = Logger.getLogger(CRSApplicationClient.class);
	UserInterface userInterface = UserOperation.getInstance();
	

	static boolean loggedIn = false;
	

	/**
	 * @param args
	 * @throws UserNotFoundException 
	 */
	public static void main(String[] args) throws UserNotFoundException {
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		CRSApplicationClient app = new CRSApplicationClient();
		
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
		logger.info("\n\n++++++++++++++++++++++++++++++++++");
		logger.info("++++++++++++  CMS  +++++++++++++++");
		logger.info("Menu for Course Management System:");
		logger.info("1. Login");
		logger.info("2. Student Registration");
		logger.info("3. Update password");
		logger.info("4. Exit");
		logger.info("++++++++++++++++++++++++++++++++++\n\n");
		
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
			
			logger.debug("Login Status -> " +  loggedIn);
			
			role = userInterface.getUserRole(userName);
			
			if(loggedIn == false || role == null) {
				logger.error("++ Login Failed Returning to Main Menu");
				return;
			}
			
			
			switch(RolesConstant.stringToName(role))
			{	
				case STUDENT:
					logger.debug("Student logged in!");
					StudentMenuCRS studentMenu=new StudentMenuCRS();
					studentMenu.renderMenu(userName);
					break;
				case PROFESSOR:
					logger.debug("Professor logged in!");
					ProfessorMenuCRS professorMenu = new ProfessorMenuCRS();
					professorMenu.renderMenu(userName);
					break;	
				case ADMIN:
					logger.debug("Admin logged in!");
					AdminMenuCRS adminMenu=new AdminMenuCRS();
					adminMenu.renderMenu(userName);
					break;
				default:
					logger.info("Invalid Input Returning to Main Menu");
			}
		
		} catch (UserNotFoundException ex) {
			logger.error("Login Failed Returning to Main Menu");
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
			logger.error("User Not Found");
		}
	}

}
