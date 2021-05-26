/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;


public class AdminClientMenu {

	public void renderMenu(String studId) {

		Scanner scanner = new Scanner(System.in);
		int choice;
		choice = scanner.nextInt();

		int c = 20;
		while (c < 20) {
			c++;

			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("++++++++ Admin Menu ++++++++");
			System.out.println("1. Add Course To Catalogue");
			System.out.println("2. Delete Course From Catalogue");
			System.out.println("3. Approve Students");
			System.out.println("4. Add Professor");
			System.out.println("5. Generate Report Card");
			System.out.println("6. Logout");

			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				addCourseToCatalogue();
				break;

			case 2:
				deleteCourseFromCatalogue();
				break;

			case 3:
				approveStudent();
				break;

			case 4:
				addProfessor();
				break;

			case 5:
				generateReportCard();

			case 6:
				crsMainLogout();
				break;
			default:
				System.out.println("***** Wrong Choice *****");

			}
		}
		scanner.close();

    }
	private void addCourseToCatalogue() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Course Code:");
		String courseCode = scanner.nextLine();

		System.out.println("Enter Course Name:");
		String courseName = scanner.next();

		scanner.close();

	}

	private void deleteCourseFromCatalogue() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Course Code:");
		String courseCode = scanner.nextLine();

		System.out.println("Enter Course Name:");
		String courseName = scanner.next();

		scanner.close();
	}

	private void addProfessor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Professor User Name:");
		String professorName = scanner.next();

		System.out.println("Enter Department:");
		String department = scanner.next();

		System.out.println("Enter Designation:");
		String designation = scanner.next();

		System.out.println("Enter Professor User Id:");
		String userId = scanner.next();

		System.out.println("Enter Password:");
		String password = scanner.next();
		scanner.close();
	}

	private void approveStudent() {
		System.out.println("Enter Student's ID:");
	}

	private void generateReportCard() {
		System.out.println("Enter Details");
	}

	public void crsMainLogout() {
		System.out.println("Inside crsMainLogout");
	}
}
