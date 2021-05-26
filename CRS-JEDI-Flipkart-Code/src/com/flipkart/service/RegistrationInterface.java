/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.SeatNotAvailableException;



public interface RegistrationInterface {
	
	/**
	 * @param cCode
	 * @param sRollNo
	 * @param courseList
	 * @return boolean if Course added successfully
	 */
	public boolean addCourse(String cCode, int sRollNo, List<Course> courseList) throws CourseNotInCatalogException,SeatNotAvailableException;
	
	/**
	 * @param cCode
	 * @param sRollNo
	 * @param registeredCourseList
	 * @return boolean if Course deleted successfully
	 */
	public boolean dropCourse(String cCode, int sRollNo, List<Course> registeredCourseList) throws CourseNotRemovedException;
	
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
	public boolean getRegistrationStatus(int sRollNo);
	
	/**
	 * @param sRollNo
	 */
	public void setRegistrationStatus(int sRollNo);
	
	
}