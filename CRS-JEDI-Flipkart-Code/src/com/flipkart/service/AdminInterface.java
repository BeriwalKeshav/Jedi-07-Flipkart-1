/**
 * 
 */
package com.flipkart.service;

import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyInCatalogException;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.ProfessorAdditionFailedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserNameAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author JEDI-7
 *
 */
public interface AdminInterface {
	
	/**
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws ProfessorAdditionFailedException,UserNameAlreadyInUseException;	
	
	/**
	 * @param sRollNo
	 * @param studentList
	 */
	public void approveStudents(String studendId, List<Student> studentList) throws StudentNotFoundForApprovalException;
	
	/**
	 * @param course
	 * @param courseList
	 */
	public void addCourse(Course course, List<Course> courseList) throws CourseAlreadyInCatalogException;
	
	/**
	 * @param courseCode
	 * @param courseList
	 */
	public void deleteCourse(String CourseCode, List<Course> courseList)throws CourseNotRemovedException,CourseNotInCatalogException;
	
	/**
	 * @param cCode
	 * @param professorId
	 */
	public void assignProfessor(String CourseCode, String professorId) throws CourseNotInCatalogException,UserNotFoundException;
	
	/**
	 * @param catalogId
	 * @return
	 */
	public List<Course> viewCourses();
	
	/**
	 * @return
	 */
	public List<Professor> showProfessors();
	
	/**
	 * @return
	 */
	public List<Student> viewPendingStudents();
	
	
	/**
	 * @return
	 */
	public List<RegisteredCourse> generateReportCard(String studentId);	

}
