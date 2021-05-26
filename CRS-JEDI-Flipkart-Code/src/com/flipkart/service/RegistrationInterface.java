/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.exception.CourseLimitCrossed;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.SeatNotAvailableException;



public interface RegistrationInterface {
	
	/**
	 * @param cCode
	 * @param sRollNo
	 * @param courseList
	 * @return boolean if Course added successfully
	 * @throws CourseLimitCrossed 
	 * @throws SQLException 
	 */
	public boolean addCourse(String cCode, String studentId, List<Course> courseList,int sem) throws CourseNotInCatalogException,SeatNotAvailableException, CourseLimitCrossed, SQLException;
	
	/**
	 * @param cCode
	 * @param sRollNo
	 * @param registeredCourseList
	 * @return boolean if Course deleted successfully
	 * @throws SQLException 
	 */
	public boolean dropCourse(String cCode,String studentId, List<Course> registeredCourseList) throws CourseNotRemovedException, SQLException;
	
	/**
	 * @param sRollNo
	 * @return List of courses
	 * @throws SQLException 
	 */
	public List<Course> viewCourses(String studentId) throws SQLException;
	
	/**
	 * @param sRollNo
	 * @return List of courses that student has registered in
	 */	
	public List<Course> viewRegisteredCourses(int sRollNo);
	
	/**
	 * @param sRollNo
	 * @return List of RegisteredCourse as it has grade and semester
	 */
	public List<RegisteredCourse> viewReportCard(int sRollNo);
	
	/**
	 * @param sRollNo
	 * @return calculated fee
	 */
	public double calculateFee(int sRollNo);
	
	/**
	 * @param sRollNo
	 * @return boolean whether Registration was approved successfully
	 */
	public int getRegistrationStatus(String studentId) throws SQLException;
	
	/**
	 * @param sRollNo
	 * @throws SQLException 
	 */
	public void setRegistrationStatus(String studentId) throws SQLException;

	
	
}