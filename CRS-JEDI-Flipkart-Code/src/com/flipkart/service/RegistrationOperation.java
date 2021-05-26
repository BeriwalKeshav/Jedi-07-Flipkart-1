/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.dao.RegistrationDAOInterface;
import com.flipkart.dao.RegistrationDAOOperation;
import com.flipkart.exception.CourseLimitCrossed;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.SeatNotAvailableException;

/**
 * @author JEDI-7
 *
 */
public class RegistrationOperation implements RegistrationInterface{
	RegistrationDAOInterface registrationDAOInterface = new RegistrationDAOOperation();
	@Override
	public boolean addCourse(String cCode, String studentId, List<Course> courseList)
			throws CourseNotInCatalogException, SeatNotAvailableException,CourseLimitCrossed,SQLException {
		// TODO Auto-generated method stub

		if (registrationDAOInterface.numOfRegisteredCourses(studentId) >= 6)
		{	
			throw new CourseLimitCrossed(6);
		}
		else if (registrationDAOInterface.isRegistered(cCode, studentId)) 
		{
			return false;
		} 
		else if (!registrationDAOInterface.seatAvailable(cCode)) 
		{
			throw new SeatNotAvailableException(cCode);
		} 
//		else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
//		{
//			throw new CourseNotFoundException(courseCode);
//		}
		
		return registrationDAOInterface.addCourse(studentId, 1,cCode);
	}

	@Override
	public boolean dropCourse(String cCode, int sRollNo, List<Course> registeredCourseList)
			throws CourseNotRemovedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewCourses(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		
		return registrationDAOInterface.viewCourses(studentId);
	}

	@Override
	public List<Course> viewRegisteredCourses(int sRollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegisteredCourse> viewReportCard(int sRollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateFee(int sRollNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRegistrationStatus(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDAOInterface.getRegistrationStatus(studentId);
	}

	@Override
	public void setRegistrationStatus(String studentId) throws SQLException{
		// TODO Auto-generated method stub
		registrationDAOInterface.setRegistrationStatus(studentId);
		
	}

}
