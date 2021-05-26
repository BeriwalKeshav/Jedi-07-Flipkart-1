/**
 * 
 */
package com.flipkart.client;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyInCatalogException;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.ProfessorAdditionFailedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.UserNameAlreadyInUseException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

public class AdminMenuCRS {

	Scanner scanner = new Scanner(System.in);

	public void renderMenu(String studId) {

		int choice = -1 ;

		
		while (choice != 9) {
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("++++++++ Admin Menu ++++++++");
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("1. View Course In Catalogue");
			System.out.println("2. Add Course To Catalogue");
			System.out.println("3. Delete Course From Catalogue");
			System.out.println("4. Approve Students");
			System.out.println("5. View Pending Admissions");
			System.out.println("6. Add Professor");
			System.out.println("7. Assign Course To Professor");
			System.out.println("8. Generate Report Card");
			System.out.println("9. Logout");
			System.out.println("++++++++++++++++++++++++++++++++");

			choice = scanner.nextInt();
			System.out.println(choice);
			switch (choice) {

			case 1:
				viewCourses();
				break;

			case 2:
				addCourseToCatalogue();
				break;

			case 3:
				deleteCourseFromCatalogue();
				break;

			case 4:
				approveStudents();
				break;

			case 5:
				viewPendingStudents();
				break;

			case 6:
				addProfessor();
				break;

			case 7:
				assignProfessor();
				break;

			case 8:
				generateReportCard();

			case 9:
				crsMainLogout();
				break;
			default:
				System.out.println("***** Wrong Choice *****");

			}
		}

	}

	AdminInterface adminOperation = new AdminOperation();

	private List<Course> viewCourses() {
		List<Course> courseList = adminOperation.viewCourses();
		if (courseList.size() == 0) {
			System.out.println("No course in the catalogue!");
			return courseList;
		}
		System.out.println(String.format("%20s | %20s | %20s", "COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		for (Course course : courseList) {
			System.out.println(
					String.format("%20s | %20s | %20s", course.getcCode(), course.getcName(), course.getProfName()));
		}
		return courseList;
	}

	private void addCourseToCatalogue() {

		List<Course> courseList = viewCourses();
		
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();

		scanner.nextLine();
		System.out.println("Enter Course Name:");

		String courseName = scanner.nextLine();
		Course course = new Course(courseCode, courseName, null, false,10);
		try {
			adminOperation.addCourse(course, courseList);
		} catch (CourseAlreadyInCatalogException e) {
			System.out.println(e.getMessage());
		}

	}

	private void deleteCourseFromCatalogue() {

		List<Course> courseList = viewCourses();
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();

		try {
			adminOperation.deleteCourse(courseCode, courseList);
		} catch (CourseNotInCatalogException | CourseNotRemovedException e) {
			System.out.println(e.getMessage());
		}
	}

	private List<Student> viewPendingStudents() {
		List<Student> pendingStudentsList = adminOperation.viewPendingStudents();
		if (pendingStudentsList.size() == 0) {
			return pendingStudentsList;
		}
		System.out.println(String.format("%20s | %20s " , "StudentId", "Name"));
		for (Student student : pendingStudentsList) {
			System.out.println(String.format("%20s | %20s ", student.getuId(), student.getuName()));
		}
		return pendingStudentsList;
	}
	
	private void approveStudents() {
		List<Student> studentList = viewPendingStudents();
		if (studentList.size() == 0) {
			return;
		}
		System.out.println("Enter Student's ID:");
		String studentUserId = scanner.next();
		
		try {
			adminOperation.approveStudents(studentUserId, studentList);
		} catch (StudentNotFoundForApprovalException e) {
			System.out.println(e.getMessage());
		}
	}

	

	private void addProfessor() {

		Professor professor = new Professor();
		
		System.out.println("Enter Professor User Name:");
		String professorName = scanner.next();
		professor.setuName(professorName);

		System.out.println("Enter Department:");
		String department = scanner.next();
		professor.setpDepartment(department);

		System.out.println("Enter Designation:");
		String designation = scanner.next();
		professor.setpDesignation(designation);

		System.out.println("Enter Professor User Id:");
		String userId = scanner.next();
		professor.setuId(userId);

		System.out.println("Enter Password:");
		String password = scanner.next();
		professor.setuPwd(password);

		System.out.println("Enter Create Date");
		// Date createDate = java.time.Date.now();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		professor.setuCrDate(date);

		try {
			adminOperation.addProfessor(professor);
		} catch (ProfessorAdditionFailedException | UserNameAlreadyInUseException e) {
			System.out.println(e.getMessage());
		}
	}

	private void assignProfessor() {
		List<Professor> professorList= adminOperation.showProfessors();
		System.out.println(String.format("%20s | %20s | %20s ", "ProfessorId", "Name", "Designation"));
		for(Professor professor : professorList) {
			System.out.println(String.format("%20s | %20s | %20s ", professor.getuId(), professor.getuName(), professor.getpDesignation()));
		}
		
		
		System.out.println("\n\n");
		List<Course> courseList= adminOperation.viewCourses();
		System.out.println(String.format("%20s | %20s", "CourseCode", "CourseName"));
		for(Course course : courseList) {
			System.out.println((String.format("%20s | %20s ", course.getcCode(), course.getcName())));
		}
		
		System.out.println(("Enter Course Code:"));
		String courseCode = scanner.next();
		
		System.out.println(("Enter Professor's User Id:"));
		String userId = scanner.next();
		
		try {
			
			adminOperation.assignProfessor(courseCode, userId);
		
		}
		catch(CourseNotInCatalogException  | UserNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
	}
	private void generateReportCard() {
		
		
		try {
			List<RegisteredCourse> registeredCourses = new ArrayList<RegisteredCourse>();
			
			System.out.println("Enter StudentId");
			String studentId=scanner.next();
			registeredCourses = adminOperation.generateReportCard(studentId);
			System.out.println(String.format("%12s %12s %12s %12s", "Course Code", "Student Id", "Semester", "Grade"));
			for(RegisteredCourse rc: registeredCourses){
				System.out.println(String.format("%12s %12s %12s %12s", rc.getcCode(), rc.getsstudentId(), rc.getSem(), rc.getGrade().getGrade()));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	
	}

	private void crsMainLogout() {
		System.out.println("++++++ Logging Out... Returning to Main Menu ++++++\n\n\n");
	}
}
