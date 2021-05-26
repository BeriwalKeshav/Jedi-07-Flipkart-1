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
 * @author prafu
 *
 */
public interface ProfessorDAOInterface {

	/**
	 * @param sRollNo
	 * @param cCode
	 * @param grade
	 * @return boolean
	 */
	public boolean addGrade(int studentRollNo,String courseCode,Grade grade) throws GradeAddFailedException;
	
	/**
	 * @param proffId
	 * @return List<RegisteredCourse>
	 */
	public List<RegisteredCourse> viewRegisteredStudents(String proffId);
	
	/**
	 * @param proffId
	 * @return List<Course>
	 */
	public List<Course> viewProfessorCourses(String proffId);
	
	/**
	 * @param profId
	 * @return 
	 */
	public Professor getProffProfleById(String profId) throws UserNotFoundException;
	
}
