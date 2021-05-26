/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseAlreadyInCatalogException;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.ProfessorAdditionFailedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserCannotBeAddedException;
import com.flipkart.exception.UserNameAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author JEDI-7
 *
 */
public interface AdminDAOInterface {

	/**
	 * Method to Add Professor
	 * @param professor : Professor to be Added
	 * @throws ProfessorAdditionFailedException
	 * @throws UserNameAlreadyInUseException
	 */
	public void addProfessor(Professor professor)
			throws ProfessorAdditionFailedException, UserNameAlreadyInUseException;

	/**
	 * Method to Add User
	 * @param user : User to be Added
	 * @throws UserCannotBeAddedException
	 * @throws UserNameAlreadyInUseException
	 */
	public void addUser(User user) throws UserCannotBeAddedException, UserNameAlreadyInUseException;

	/** 
	 * Method to Approve Student
	 * @param sRollNo
	 * @throws StudentNotFoundForApprovalException
	 */
	public void approveStudents(String studentId) throws StudentNotFoundForApprovalException;

	/**
	 * @param course
	 * @throws CourseAlreadyInCatalogException
	 */
	public void addCourse(Course course) throws CourseAlreadyInCatalogException;

	/**
	 * @param CourseCode
	 * @throws CourseNotRemovedException
	 * @throws CourseNotInCatalogException
	 */
	public void deleteCourse(String CourseCode) throws CourseNotRemovedException, CourseNotInCatalogException;
	
	/**
	 * @param CourseCode
	 * @param professorId
	 * @throws CourseNotInCatalogException
	 * @throws UserNotFoundException
	 */
	public void assignProfessor(String CourseCode, String professorId)
			throws CourseNotInCatalogException, UserNotFoundException;

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
