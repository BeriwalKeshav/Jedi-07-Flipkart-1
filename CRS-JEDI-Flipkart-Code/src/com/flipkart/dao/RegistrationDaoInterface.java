/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.RegisteredCourse;
//import com.flipkart.constant.ModeOfPayment;
import com.flipkart.exception.CourseNotOfferedException;

/**
 * @author JEDI-7
 *
 */
public interface RegistrationDaoInterface {
	
	
	/**
	 * @param courseCode
	 * @param studentId
	 * @param semester
	 * @return boolean whether course got added successfully
	 * @throws SQLException
	 */
	public boolean addCourse(String studentId,int semester, String courseCode) throws SQLException;
	
	/**
	 * @param courseCode
	 * @param studentId
	 * @param semester
	 * @return boolean whether course got added successfully
	 * @throws SQLException
	 */
	public boolean dropCourse(String studentId,int semester, String courseCode) throws SQLException;
	
	
	/**
	 * @param studentId
	 * @return list of courses
	 * @throws SQLException
	 */
	public List<Course> viewCourses(String studentId) throws SQLException;
	
	/**
	 * @param studentId
	 * @return list of registered courses
	 * @throws SQLException
	 */
	public List<Course> viewRegisteredCourses(String studentId) throws SQLException;
	
	/**
	 * @param studentId
	 * @param semester
	 * @return list of registered courses containing grade
	 * @throws SQLException
	 */
	public List<RegisteredCourse> viewReportCard(String studentId,int semester) throws SQLException;
	
	/**
	 * @param studentId
	 * @return calculated fee the student has to pay
	 * @throws SQLException
	 */
	public double calculateFee(String studentId) throws SQLException;
	
	/**
	 * @param courseCode
	 * @return boolean whether seat is available in a course
	 * @throws SQLException
	 */
	public boolean seatAvailable(String courseCode) throws SQLException;
	
	/**
	 * @param studentId
	 * @return number of courses student has registered in
	 * @throws SQLException
	 */
	public int numOfRegisteredCourses(String studentId) throws SQLException;
	
	/**
	 * @param courseCode
	 * @param studentId
	 * @return boolean whether student is registered in a particular course
	 * @throws SQLException
	 */
	public boolean isRegistered(String courseCode, String studentId) throws SQLException;
	
	/**
	 * @param studentId
	 * @return boolean stating student's registration status
	 * @throws SQLException
	 */
	public boolean getRegistrationStatus(String studentId) throws SQLException;
	
	/**
	 * set student's registration status
	 * @param studentId
	 * @throws SQLException
	 */
	public void setRegistrationStatus(String studentId) throws SQLException;
}
