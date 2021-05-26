package com.flipkart.client;

import java.util.*;
import java.sql.SQLException;
import com.flipkart.bean.Course;
import com.flipkart.exception.CourseLimitCrossed;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;

/**
 * @author JEDI-7
 * Class To Display The Student Client Menu.
 *
 */
public class StudentMenuCRS {

	RegistrationInterface registrationinterface = new RegistrationOperation();
	Scanner sc = new Scanner(System.in);
	private int if_registered;
	private int sem=1;

	public void renderMenu(String studentId) {

		if_registered = getRegistrationStatus(studentId);

		boolean b = true;
		while (b) {
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++ Student Menu ++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++");
			System.out.println("1. Enter 1 To View Catalog Of Courses.");
			System.out.println("2. Enter 2 To Register For Courses.");
			System.out.println("3. Enter 3 To View Registered Courses.");
			System.out.println("4. Enter 4 To Add Course.");
			System.out.println("5. Enter 5 To Drop Course.");
			System.out.println("6. Enter 6 To View Report Card");
			System.out.println("7. Enter 7 To Logout From The System."); 

			int c = sc.nextInt();
			
			switch(c) {
				case 1:
					viewCatalog(studentId);
					break;
				case 2:
					registerCourses(studentId);
					break;
				case 3:
					viewRegisteredCourses(studentId);
					break;
				case 4:
					addCourses(studentId);
					break;
				case 5:
					dropCourses(studentId);
					break;
				case 6:
					viewReportCard(studentId);
					break;
				case 7:
					b = false;
					logout(studentId);
					break;
				default:{
					System.out.println("+++++++++ Wrong Choice !!!!! +++++");
					System.out.println("+++++++++ Please Enter The Valid One ++++++++");
				}
			}
		}
	}

	/**
	 * Method To View Catalog Of Courses.
	 * @param studentId
	 * @return List Of Available Courses 
	 */
	public List<Course> viewCatalog(String studentId) {
		List<Course> course_avail = null;
		try {
			course_avail = registrationinterface.viewCourses(studentId);
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		if (course_avail.isEmpty()) {
			System.out.println("No Course is Available");
			return null;
		}
		System.out.println("The Following Courses are available:");
		System.out.println(" COURSE CODE " + " COURSE NAME " + " INSTRUCTOR " + " SEATS ");
		for (Course obj : course_avail) {
			System.out.println(
					obj.getcCode() + " " + obj.getcName() + " " + obj.getProfName() + " " + obj.getNoOfSeats());
		}
		return course_avail;
	}

	/**
	 * Method To Register For Courses.
	 * @param studentId
	 * @return List of Registered Courses
	 * @throws Course Not In Catalog Exception.
	 * @throws Seat Not Available Exception.
	 * @throws Course Limit Crossed Exception. 
	 **/
	public void registerCourses(String studentId) {
		if (if_registered > 0) {
			System.out.println("Registration is already complete");
			return;
		}
		System.out.println("Enter the semester for which you want to register!");
		sem=sc.nextInt();
		int course_count = 0;
		System.out.println("Choose 4 Primaary Courses");
		while (course_count < 4) {
			try {
				List<Course> avail_course = viewCatalog(studentId);
				if (avail_course == null) {
					return;
				}
				System.out.println("Enter Course code for Course " + (course_count + 1));
				String courseCode = sc.next();
				if (registrationinterface.addCourse(courseCode, studentId, avail_course,sem)) {
					System.out.println("Course " + courseCode + " added Sucessfully");
				} else {
					System.out.println("Already Registerd for the course: " + courseCode);
				}

			} catch (SQLException | CourseNotInCatalogException | SeatNotAvailableException | CourseLimitCrossed e) {
				System.out.println(e.getMessage());

			}
			course_count++;
		}
		System.out.println("Choose 2 Optional Courses");
		while(course_count<6) {
			try {
				List<Course> avail_course = viewCatalog(studentId);
				if (avail_course == null) {
					return;
				}
				System.out.println("Enter Course code for Course " + (course_count + 1));
				String courseCode = sc.next();
				if (registrationinterface.addCourse(courseCode, studentId, avail_course,sem)) {
					System.out.println("Course " + courseCode + " added Sucessfully");
				} else {
					System.out.println("Already Registerd for the course: " + courseCode);
				}

			} catch (SQLException | CourseNotInCatalogException | SeatNotAvailableException | CourseLimitCrossed e) {
				System.out.println(e.getMessage());

			}
			course_count++;
		}
		System.out.println("Student " + studentId + " registerd sucesssfully");
		if_registered = 1;
		try {
			registrationinterface.setRegistrationStatus(studentId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Method To View Registered Courses.
	 * @param studentId
	 * @return List of Registered Courses
	 */
	public List<Course> viewRegisteredCourses(String studentId) {
		List<Course> registeredCourses=null;
		try {
			registeredCourses = registrationinterface.viewRegisteredCourses(studentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registeredCourses.isEmpty()) {
			System.out.println("You have not yet registered for any Course");
			return null;
		}
		else {
			System.out.println("Course Code" + "Course Name" + "Professor" + "");
			for(Course obj : registeredCourses) {
				System.out.println(obj.getcCode() + " " + obj.getcName() + " " + obj.getProfName());
			}
			return registeredCourses;
		}

	}
	
	/**
	 * Method To Add Course For Registration
	 * @param studentId
	 * @throws Course Not In Catalog Exception. 
	 * @throws Seat Not Available Exception.
	 * @throws Course Limit Crossed Exception. 
	 */
	public void addCourses(String studentId) {

		if (if_registered == 0) {
			System.out.println("Registration is not complete");
			return;
		}

		List<Course> courseAvail = viewCatalog(studentId);
		if (courseAvail == null) {
			return;
		}
		System.out.println("Enter Course Code");
		String cCode = sc.next();
		try {
			if (registrationinterface.addCourse(cCode, studentId, courseAvail,sem))
				System.out.println("Course has been added");
			else
				System.out.println("You have already registered for the course");
		} catch (CourseNotInCatalogException | SeatNotAvailableException | CourseLimitCrossed | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void dropCourses(String studentId) {
		if (if_registered == 0) {
			System.out.println("Registration is not complete");
			return;
		}
		List<Course> registeredCourseList = viewRegisteredCourses(studentId);

		if (registeredCourseList == null)
			return;

		System.out.println("Enter the Course Code : ");
		String courseCode = sc.next();

		try {
			registrationinterface.dropCourse(courseCode, studentId, registeredCourseList,sem);
			System.out.println("You have successfully dropped Course : " + courseCode);

		} catch (CourseNotRemovedException e) {
			System.out.println("You have not registered for course : " + courseCode);
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

	public void viewReportCard(String studentId) {
		System.out.println("Show ReportCard ");
	}

	public void logout(String studentId) {
		System.out.println("Logout ");
	}

	public int getRegistrationStatus(String studentId) {
		try {
			return registrationinterface.getRegistrationStatus(studentId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;

	}

}
