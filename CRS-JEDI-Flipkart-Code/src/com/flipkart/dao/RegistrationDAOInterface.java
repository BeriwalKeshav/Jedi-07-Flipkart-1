package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

/**
 * @author JEDI-03
 * Interface for Registration DAO Operation
 *
 */
public interface RegistrationDAOInterface {
	
	
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
	
	
	
	public List<Course> viewCourses(String studentId) throws SQLException;
	

	/**
	 * Method to View list of Registered Courses
	 * @param studentId
	 * @return list of Registered Courses
	 * @throws SQLException 
	 */
	public List<Course> viewRegisteredCourses(String studentId) throws SQLException;
	
	
	/**
	 * Method to view report card of the student
	 * @param studentId
	 * @return Grade Card
	 * @throws SQLException 
	 */
	
	public List<RegisteredCourse> viewReportCard(String studentId,int semester) throws SQLException;
	
	/**
	 * Method to retrieve fee for the selected courses from the database and calculate total fee
	 * @param studentId
	 * @return Fee Student has to pay
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

	 * Method to get the list of courses registered by the student
	 * Number of registered courses for a student
	 * @param studentId
	 * @return Number of registered Courses
	 * @throws SQLException 
	 */
	public int numOfRegisteredCourses(String studentId) throws SQLException;
	
	/**
	 * Method checks if the student is registered for that course
	 * @param courseCode
	 * @param studentId
	 * @return Students registration status
	 * @throws SQLException 
	 */
	public boolean isRegistered(String courseCode, String studentId) throws SQLException;
	
	/**
	 *  Method to get student registration status
	 * @param studentId
	 * @return Student's registration status
	 * @throws SQLException
	 */
	public int getRegistrationStatus(String studentId) throws SQLException;
	
	/**
	 *  Method to set student registration status
	 * @param studentId
	 * @throws SQLException
	 */
	public void setRegistrationStatus(String studentId) throws SQLException;
	
	
}
