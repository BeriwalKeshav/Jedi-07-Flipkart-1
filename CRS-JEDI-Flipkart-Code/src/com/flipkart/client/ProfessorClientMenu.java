/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

/**
 * @author prafu
 *
 */
public class ProfessorClientMenu {
	
	/**
	 * @param proffId
	 */
	public void renderMenu(String proffId) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		int curr = 20;
		while(curr < 20) { // Check login
			curr++; 
			
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("++++++++ Professor Menu ++++++++");
			System.out.println("1. Add Grade");
			System.out.println("2. View Registered Students");
			System.out.println("3. View My Courses");
			System.out.println("4. Logout");
			
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
					crsMainLogout();
					break;
				default:
					System.out.println("+++ Warning : Wrong Option +++");
					
			}
			
		 }
		 sc.close();
	}
	
	/**
	 * @param proffId
	 */
	public void getMyCourses(String proffId) {
		System.out.println("Inside getMyCourses");
	}
	
	/**
	 * @param proffId
	 */
	public void addGrade(String proffId) {
		System.out.println("Inside addGrade");
		
		Scanner sc = new Scanner(System.in);
		int studentId;
		String grade,courseCode;
		
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("++++++++ Add Grade Menu ++++++++");
		System.out.println("Enter Student Id");
		studentId = sc.nextInt();
		System.out.println("Enter Course Code");
		courseCode = sc.next();
		System.out.println("Enter Grade");
		grade = sc.next();
		
		System.out.println("Updated grade to " + grade + " of student " + studentId + " and course code " +  courseCode);
		sc.close();
	}
	
	/**
	 * @param proffId
	 */
	public void viewRegisteredStudents(String proffId) {
		System.out.println("Inside viewRegisteredStudents");
	}
	
	/**
	 * 
	 */
	public void crsMainLogout() {
		System.out.println("Inside crsMainLogout");
	}
}
