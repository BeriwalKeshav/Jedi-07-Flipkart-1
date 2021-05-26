/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.exception.GradeAddFailedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author prafu
 *
 */
public class ProfessorClientMenu {
	
	/**
	 * @param proffId
	 */
	
	ProfessorInterface proffInterface = new ProfessorOperation();
	
	
	public void renderMenu(String proffId) {
		
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		
		while(choice != 5) {
			
			System.out.println("\n\n\n++++++++++++++++++++++++++++++++");
			System.out.println("++++++++ Professor Menu ++++++++");
			System.out.println("1. Add Grade");
			System.out.println("2. View Registered Students");
			System.out.println("3. View My Courses");
			System.out.println("4. View My Details");
			System.out.println("5. Logout");
			
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addGrade(proffId);
					break;
				case 2:
					viewRegisteredStudents(proffId);
					break;
				case 3:
					getMyCourses(proffId);
					break;
				case 4:
					viewMyDetails(proffId);
					break;
				case 5:
					crsMainLogout();
					break;
				default:
					System.out.println("+++ Warning : Wrong Option +++");
					
			}
			
		 }
		 // sc.close();
	}
	
	private void viewMyDetails(String proffId) {
		try {
			
			Professor proff = proffInterface.getProffProfleById(proffId);
			
			System.out.println(String.format("%15s %15s", "Designation", "Department"));
			System.out.println(String.format("%15s %15s", proff.getpDesignation(), proff.getpDepartment()));
		} catch (Exception ex) {
			System.out.println("++ Some Error Occurred returning to Menu");
		}
		
	}

	/**
	 * @param proffId
	 */
	public void getMyCourses(String proffId) {
		try {
			List<Course> myCourses = new ArrayList<Course>();
			
			myCourses = proffInterface.viewProfessorCourses(proffId);
			
			System.out.println(String.format("%20s %20s %20s %20s", "Course Code", "Course Name", "Professor Name", "Is Offered"));
			for(Course cr: myCourses){
				System.out.println(String.format("%20s %20s %20s %20s", cr.getcCode(), cr.getcName(), cr.getProfName(), cr.isOffered()));
			}
		} catch (Exception ex) {
			System.out.println("++ Some Error Occurred returning to Menu");
		}
	}
	
	/**
	 * @param proffId
	 */
	public void addGrade(String proffId) {
		
		Scanner sc = new Scanner(System.in);
		
		String grade,courseCode,studentId;
		
		
		
		try{
			
			System.out.println("++++++++++++++++++++++++++++++++");
			viewRegisteredStudents(proffId);
			System.out.println("++++++++ Add Grade Menu ++++++++");
			System.out.println("Enter Student Id");
			studentId = sc.next();
			System.out.println("Enter Course Code");
			courseCode = sc.next();
			System.out.println("Enter Grade");
			grade = sc.next();
			
			boolean isUpdated = proffInterface.addGrade(studentId, courseCode, new Grade(grade));
			if( isUpdated == true) {
				return;
			}else {
				System.out.println("+++++++ Password Update Failed");
			}
		
		} catch (GradeAddFailedException ex) {
			System.out.println("++ User Not Found");
		}
		
	}
	
	/**
	 * @param proffId
	 */
	public void viewRegisteredStudents(String proffId) {
		try {
			List<RegisteredCourse> registeredCourses = new ArrayList<RegisteredCourse>();
			
			registeredCourses = proffInterface.viewRegisteredStudents(proffId);
			
			System.out.println(String.format("%12s %12s %12s", "Course Code", "Student Id", "Semester"));
			for(RegisteredCourse rc: registeredCourses){
				System.out.println(String.format("%12s %12s %12s", rc.getcCode(), rc.getsstudentId(), rc.getSem()));
			}
		} catch (Exception ex) {
			System.out.println("++ Some Error Occurred returning to Menu");
		}
	}
	
	/**
	 * 
	 */
	public void crsMainLogout() {
		System.out.println("++++++ Logging Out... Returning to Main Menu ++++++\n\n\n");
	}
}
