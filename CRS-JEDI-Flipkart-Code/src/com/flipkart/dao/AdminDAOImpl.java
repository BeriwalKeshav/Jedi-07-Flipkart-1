/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLQueriesConstanst;
import com.flipkart.exception.CourseAlreadyInCatalogException;
import com.flipkart.exception.CourseNotInCatalogException;
import com.flipkart.exception.CourseNotRemovedException;
import com.flipkart.exception.ProfessorAdditionFailedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserCannotBeAddedException;
import com.flipkart.exception.UserNameAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;

/**
 * @author JEDI-7
 *
 */
public class AdminDAOImpl implements AdminDAOInterface {

	private PreparedStatement statement = null;

	Connection connection = DBUtil.getConnection();

	/**
	 *
	 */
	public void addProfessor(Professor professor)
			throws ProfessorAdditionFailedException, UserNameAlreadyInUseException {
		try {

			this.addUser(professor);

		} catch (UserCannotBeAddedException e) {

			System.out.println(e.getMessage());
			throw new ProfessorAdditionFailedException(professor.getuName());

		} catch (UserNameAlreadyInUseException e) {

			System.out.println(e.getMessage());
			throw e;

		}

		statement = null;
		try {

			String sql = SQLQueriesConstanst.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, professor.getpDepartment());
			statement.setString(2, professor.getpDesignation());
			statement.setString(3, professor.getuName());

			int row = statement.executeUpdate();

			System.out.println(row + " Professor Added.");
			if (row == 0) {
				System.out.println("Professor with ProfessorUserName: " + professor.getuName() + " not added.");
				throw new ProfessorAdditionFailedException(professor.getuName());
			}

			System.out.println("Professor with ProfessorUserName: " + professor.getuName() + " added.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());
			throw new UserNameAlreadyInUseException(professor.getuName());

		}

	}

	/**
	 *
	 */
	public void addUser(User user) throws UserCannotBeAddedException, UserNameAlreadyInUseException {

		statement = null;
		try {

			String sql = SQLQueriesConstanst.ADD_USER_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, user.getuId());
			statement.setString(2, user.getuName());
			statement.setString(3, user.getuPwd());
			statement.setDate(4, (Date) user.getuCrDate());
			int row = statement.executeUpdate();

			System.out.println(row + " user added.");
			if (row == 0) {
				System.out.println("User with User Name: " + user.getuId() + " not added.");
				throw new UserCannotBeAddedException(user.getuId());
			}

			System.out.println("User with User Name: " + user.getuName() + " added.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());
			throw new UserNameAlreadyInUseException(user.getuName());

		}

	}

	/**
	 *
	 */
	public void approveStudents(String studentId) throws StudentNotFoundForApprovalException {

		statement = null;
		try {
			String sql = SQLQueriesConstanst.APPROVE_STUDENT_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, studentId);
			int row = statement.executeUpdate();

			System.out.println(row + " student approved.");
			if (row == 0) {
				System.out.println("Student with student id  : " + studentId + " not found.");
				throw new StudentNotFoundForApprovalException(studentId);
			}

			System.out.println("Student with studentId: " + studentId + " approved by admin.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}

	}

	/**
	 *
	 */
	public void addCourse(Course course) throws CourseAlreadyInCatalogException {

		statement = null;
		try {

			String sql = SQLQueriesConstanst.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, course.getcCode());
			statement.setString(2, course.getcName());

			int row = statement.executeUpdate();

			System.out.println(row + " course added");
			if (row == 0) {
				System.out.println("Course with courseCode: " + course.getcCode() + "not added to catalog.");
				throw new CourseAlreadyInCatalogException(course.getcCode());
			}

			System.out.println("Course with courseCode: " + course.getcCode() + " is added to catalog.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());
			throw new CourseAlreadyInCatalogException(course.getcCode());
		}
	}

	/**
	 *
	 */
	public void deleteCourse(String CourseCode) throws CourseNotRemovedException, CourseNotInCatalogException {

		statement = null;
		try {
			String sql = SQLQueriesConstanst.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, CourseCode);
			int row = statement.executeUpdate();

			System.out.println(row + " entries deleted.");
			if (row == 0) {
				System.out.println(CourseCode + " not in catalog!");
				throw new CourseNotInCatalogException(CourseCode);
			}

			System.out.println("Course with courseCode: " + CourseCode + " deleted.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());
			throw new CourseNotRemovedException(CourseCode);
		}
	}

	/**
	 *
	 */
	public void assignProfessor(String CourseCode, String professorId)
			throws CourseNotInCatalogException, UserNotFoundException {

		statement = null;
		try {
			String sql = SQLQueriesConstanst.ASSIGN_COURSE_QUERY;
			statement = connection.prepareStatement(sql);

			statement.setString(1, professorId);
			statement.setString(2, CourseCode);
			int row = statement.executeUpdate();

			System.out.println(row + " course assigned.");
			if (row == 0) {
				System.out.println(CourseCode + " not found");
				throw new CourseNotInCatalogException(CourseCode);
			}

			System.out.println("Course with courseCode: " + CourseCode + " is assigned to professor with professorId: "
					+ professorId + ".");

		} catch (SQLException se) {

			System.out.println(se.getMessage());
			throw new UserNotFoundException(professorId);

		}
	}

	/**
	 *
	 */
	public List<Course> viewCourses() {

		statement = null;
		List<Course> courseList = new ArrayList<>();
		try {

			String sql = SQLQueriesConstanst.VIEW_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Course course = new Course();
				course.setcCode(resultSet.getString(1));
				course.setcName(resultSet.getString(2));
				courseList.add(course);

			}

			System.out.println(courseList.size() + "Courses Present In Catalog");

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}

		return courseList;
	}

	/**
	 *
	 */
	public List<Professor> showProfessors() {

		statement = null;
		List<Professor> professorList = new ArrayList<>();
		try {

			String sql = SQLQueriesConstanst.VIEW_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Professor professor = new Professor();
				professor.setpDepartment(resultSet.getString(1));
				professor.setpDesignation(resultSet.getString(2));
				professorList.add(professor);

			}

			System.out.println(professorList.size() + " professors in the institute.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}
		return professorList;
	}

	/**
	 *
	 */
	public List<Student> viewPendingStudents() {

		statement = null;
		List<Student> userList = new ArrayList<Student>();
		try {

			String sql = SQLQueriesConstanst.VIEW_PENDING_ADMISSION_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Student user = new Student();
				user.setuId(resultSet.getString(1));
				user.setuName(resultSet.getString(2));
				user.setsBranch(resultSet.getString(3));
				userList.add(user);

			}

			System.out.println(userList.size() + " students have pending-approval.");

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}

		return userList;
	}
}