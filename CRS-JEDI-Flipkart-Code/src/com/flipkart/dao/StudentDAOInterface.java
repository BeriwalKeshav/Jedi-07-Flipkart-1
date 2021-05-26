/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author JEDI-7
 * Interface for Student Operations
 */
public interface StudentDAOInterface {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the student fields
	 * @return boolean true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public boolean addStudent(Student student) throws StudentNotRegisteredException;
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	public String getStudentId(String userId);
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public boolean isApproved(String studentId);
}
