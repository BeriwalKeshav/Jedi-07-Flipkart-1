package com.flipkart.client;

import com.flipkart.*;
import java.util.*;
import java.sql.SQLException;
import com.flipkart.bean.Course;
import com.flipkart.exception.CourseLimitCrossed;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;
public class StudentClientMenu {
	RegistrationInterface registrationinterface = new RegistrationOperation();
	Scanner sc= new Scanner(System.in); 
	private int if_registered;
	public void renderMenu(String studentId)
	{
		
		if_registered=getRegistrationStatus(studentId);
	
		boolean b = true;
		while(b)
		{
			
			System.out.println("+++++    Student Menu    ++++++++");
			System.out.println("");
			System.out.println("1. View Catalog");
			System.out.println("2. Register for Courses ");
			System.out.println("3. View Registered Courses");
			System.out.println("4. Add Courses");
			System.out.println("5. Drop Courses");
			System.out.println("6. ViewReportCard");
			System.out.println("7. Logout");
//			Scanner sc= new Scanner(System.in); 
			
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
				default:
					System.out.println("+++ Warning : Wrong Option +++");
			}
		}
	}
	public List<Course> viewCatalog(String studentId) {
//		System.out.println("Show Catalog ");
		List<Course> course_avail=null;
		try 
		{
			course_avail = registrationinterface.viewCourses(studentId);
		}
		catch (SQLException e) 
		{

            System.out.println(e.getMessage());
		}
		if(course_avail.isEmpty())
		{
			System.out.println("No Course is Available");
			return null;
		}
		

		System.out.println(" COURSE CODE "+ " COURSE NAME "+ " INSTRUCTOR "+ " SEATS ");
		for(Course obj : course_avail)
		{
			System.out.println(obj.getcCode() +" " + obj.getcName() +" "+  obj.getProfName() +" "+ obj.getNoOfSeats());
		}
		return course_avail;
	}
	public void registerCourses(String studentId) {
		if(if_registered>0) {
			System.out.println("Registration is already complete");
			return;
		}
		int course_count=0;
		while(course_count<6) {
			try {
				List<Course>avail_course=viewCatalog(studentId);
				if(avail_course==null) {
					return;
				}
				System.out.println("Enter Course code for Course"+(course_count+1));
				String courseCode=sc.next();
				if(registrationinterface.addCourse(courseCode,studentId, avail_course)) {
					System.out.println("Course "+courseCode +" added Sucessfully");
				}
				else {
					System.out.println("Already Registerd for the course: "+ courseCode);
				}
				
			}
			catch(SQLException | CourseNotInCatalogException | SeatNotAvailableException | CourseLimitCrossed e){
				System.out.println(e.getMessage());
				
			}
			course_count++;
		}
		System.out.println("Student "+studentId + " registerd sucesssfully");
		if_registered=1;
		try {
			registrationinterface.setRegistrationStatus(studentId);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
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
				System.out.println(obj.getcCode() + " " + obj.getcName() + " " + obj.getProfName() + " " + obj.getNoOfSeats());
			}
			return registeredCourses;
		}

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
	public int getRegistrationStatus(String studentId) {
		try {
			return registrationinterface.getRegistrationStatus(studentId);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
			
	}
		
}
