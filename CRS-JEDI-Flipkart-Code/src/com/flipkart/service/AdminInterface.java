/**
 * 
 */
package com.flipkart.service;

import java.util.List;
import java.util.UUID;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyInCatalogException;
import com.flipkart.exception.CourseNotOfferedException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.ProfessorAdditionFailedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserNameAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author keshavberiwal
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
	public void approveStudents(int sRollNo, List<Student> studentList) throws StudentNotFoundForApprovalException;
	
	/**
	 * @param course
	 * @param courseList
	 */
	public void addCourse(Course course, List<Course> courseList) throws CourseAlreadyInCatalogException;
	
	/**
	 * @param courseCode
	 * @param courseList
	 */
	public void deleteCourse(String cCode, List<Course> courseList)throws CourseNotRemovedException,CourseNotOfferedException;
	
	/**
	 * @param cCode
	 * @param professorId
	 */
	public void assignProfessor(String cCode, String professorId) throws CourseNotOfferedException,UserNotFoundException;
	
	/**
	 * @param catalogId
	 * @return
	 */
	public List<Course> viewCourses(int catalogId);
	
	/**
	 * @return
	 */
	public List<Professor> showProfessors();
	
	/**
	 * @return
	 */
	public List<Student> viewPendingStudents();
	
	

}
