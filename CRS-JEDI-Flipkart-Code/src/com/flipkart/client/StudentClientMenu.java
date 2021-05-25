package com.flipkart.client;

import java.util.*;
public class StudentClientMenu {
	public void renderMenu(String studentId)
	{
		System.out.println("       Student Menu");
		System.out.println("");
		System.out.println("1. View Catalog");
		System.out.println("2. Register for Courses ");
		System.out.println("3. Add Courses");
		System.out.println("4. Drop Courses");
		System.out.println("5. ViewReportCard");
		System.out.println("6. Logout");
		Scanner sc= new Scanner(System.in); 
		int c = sc.nextInt();
		//sc.close();
		boolean b = true;
		while(b)
		{
			switch(c) {
				case 1:
					b = false;
					viewCatalog(studentId);
					break;
				case 2:
					registerCourses(studentId);
					break;
				case 3:
					addCourses(studentId);
					break;
				case 4:
					dropCourses(studentId);
					break;
				case 5:
					viewReportCard(studentId);
				case 6:
					logout(studentId);
				default:
					System.out.println("+++ Warning : Wrong Option +++");
			}
		}
	}
	public void viewCatalog(String studentId) {
		System.out.println("Show Catalog ");
	}
	public void registerCourses(String studentId) {
		System.out.println("Show Catalog ");
	}
	public void addCourses(String studentId) {
		System.out.println("Show Catalog ");
	}
	public void dropCourses(String studentId) {
		System.out.println("Drop the course ");
	}
	public void viewReportCard(String studentId) {
		System.out.println("Show ReportCard ");
	}
	public void logout(String studentId) {
		System.out.println("Logout ");
	}
		
}
