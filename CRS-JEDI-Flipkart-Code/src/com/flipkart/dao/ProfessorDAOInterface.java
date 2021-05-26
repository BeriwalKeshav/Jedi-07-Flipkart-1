/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.exception.GradeAddFailedException;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author JEDI-7
 *
 */
public interface ProfessorDAOInterface {

	/**
	 * Method to Add grade
	 * @param studentId
	 * @param cCode
	 * @param grade
	 */
	public boolean addGrade(String studentId,String courseCode,Grade grade) throws GradeAddFailedException;
	
	/**
	 * Method to view registered students under a professor
	 * @param proffId
	 * @return List<RegisteredCourse>
	 */
	public List<RegisteredCourse> viewRegisteredStudents(String proffId);
	
	/**
	 * Method to view courses offered by a professor
	 * @param proffId
	 * @return List<Course>
	 */
	public List<Course> viewProfessorCourses(String proffId);
	
	/**
	 * Method to View Professor's Profile
	 * @param profId
	 * @return 
	 */
	public Professor getProffProfleById(String profId) throws UserNotFoundException;
	
}
