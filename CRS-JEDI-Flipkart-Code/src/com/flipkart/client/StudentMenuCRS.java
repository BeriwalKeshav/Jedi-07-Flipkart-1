package com.flipkart.client;

import java.util.*;
import java.sql.SQLException;
import com.flipkart.bean.Course;
import com.flipkart.constants.ModeOfPayment;
import com.flipkart.dao.NotificationDAOInterface;
import com.flipkart.dao.NotificationDAOOperation;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Notification;
import com.flipkart.exception.CourseLimitCrossed;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.service.NotificationInterface;
import com.flipkart.service.NotificationOpearation;
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
			System.out.println("7. Make Payment");			
			System.out.println("8. View Notifications");
			System.out.println("9. Enter 7 To Logout From The System."); 

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
					make_payment(studentId);
				case 8: 
					viewAllNotifications(studentId);
					break;
				case 9:
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
	
	public void viewAllNotifications(String StudentId) {
		List<Notification> allNotifications = null; 
		NotificationInterface notify = NotificationOpearation.getInstance();
		try {
			allNotifications = notify.getAllNotifications(StudentId);
		}
		catch (SQLException ex){
			System.out.println("Some Error Occured!");
		}
		System.out.println("You have " + allNotifications.size() + " Notifications!\n");
		for(Notification nf: allNotifications) {
			System.out.println(nf.getNotifyId() + '\t' + nf.getMsg());
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
		try {
			List<RegisteredCourse> registeredCourses = new ArrayList<RegisteredCourse>();
			registeredCourses = registrationinterface.viewReportCard(studentId);
			System.out.println("Student Username: "+studentId);
			System.out.println(String.format("%12s %12s %12s", "Course Code", "Semester", "Grade"));
			for(RegisteredCourse rc: registeredCourses){
				System.out.println(String.format("%12s %12s %12s", rc.getcCode(), rc.getSem(), rc.getGrade().getGrade()));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	
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
	
	/**
	 * Make Payment for selected courses. Student is provided with an option to pay the fees and select the mode of payment.
	 * @param studentId
	 */
	private void make_payment(String studentId)
	{
		
		int fee = 0;
		try
		{
			fee = registrationinterface.calculateFee(studentId);
		} 
		catch (SQLException e) 
		{

            System.out.println(e.getMessage());
		}

		if(fee == 0)
		{
			System.out.println("You have no outstanding payment");
		}
		else
		{
			
			System.out.println("Your total fee  = " + fee);
			System.out.println("Want to continue Fee Payment(y/n)");
			String ch = sc.next();
			if(ch.equals("y"))
			{
				System.out.println("Select Mode of Payment:");
				
				int index = 1;
				for(ModeOfPayment mode : ModeOfPayment.values())
				{
					System.out.println(index + ". " + mode);
					index = index + 1;
				}
				
				ModeOfPayment mode = ModeOfPayment.getModeofPayment(sc.nextInt());
				NotificationDAOInterface notificationDaoOperation = NotificationDAOOperation.getInstance();
				NotificationInterface notificationInterface = NotificationOpearation.getInstance();
				
				if(mode == null)
					System.out.println("Invalid Input");
				else
				{
					try 
					{
						String referenceId = notificationDaoOperation.addPayment(studentId, fee, true, mode.toString());
						String message = mode.toString() + " Payment";
						notificationInterface.sendNotification(message, studentId, referenceId);
					}
					catch (Exception e) 
					{

			            System.out.println(e.getMessage());
					}
				}
					
			}
			
		}
		
	}

}