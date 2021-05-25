/**
 * 
 */
package com.flipkart.service;

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
public interface ProfessorInterface {
	
	
	/**
	 * @param sRollNo
	 * @param cCode
	 * @param grade
	 * @return boolean
	 */
	public boolean addGrade(int sRollNo,String cCode,Grade grade) throws GradeAddFailedException;
	
	/**
	 * @param courseId
	 * @return List<RegisteredCourse>
	 */
	public List<RegisteredCourse> viewRegisteredStudents(String courseId);
	
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
