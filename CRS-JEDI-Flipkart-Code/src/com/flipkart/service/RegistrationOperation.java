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
import com.flipkart.exception.CourseNotOfferedException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.SeatNotAvailableException;

/**
 * @author JEDI-7
 *
 */
public class RegistrationOperation implements RegistrationInterface{
	RegistrationDAOInterface registrationDAOInterface = new RegistrationDAOOperation();
	@Override
	public boolean addCourse(String cCode, int sRollNo, List<Course> courseList)
			throws CourseNotOfferedException, SeatNotAvailableException {
		// TODO Auto-generated method stub
		return false;
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
	public boolean getRegistrationStatus(int sRollNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegistrationStatus(int sRollNo) {
		// TODO Auto-generated method stub
		
	}

}
