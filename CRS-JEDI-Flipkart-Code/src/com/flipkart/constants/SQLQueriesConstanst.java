/**
 * 
 */
package com.flipkart.constants;

/**
 * @author prafu
 *
 */
public class SQLQueriesConstanst {

	
	public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userName = ? AND passwordHash = ?";
	public static final String ADD_PROFESSOR_QUERY = "INSERT INTO professor(department, designation, proffid) VALUES (?, ?, ?)";
	public static final String ADD_USER_QUERY = "INSERT INTO user(userId, userName, passwordHash, createDate) values (?, ?, ?, ?)";
	public static final String APPROVE_STUDENT_QUERY = "UPDATE student SET approved = 1 where studentId = ?";
	public static final String ADD_COURSE_QUERY = "INSERT INTO course(cCode, cName) values (?, ?)";
	public static final String DELETE_COURSE_QUERY = "DELETE FROM course WHERE cCode = ?";
	public static final String ASSIGN_COURSE_QUERY = "UPDATE course SET professorId = ? where cCode = ?";
	public static final String VIEW_COURSE_QUERY = "select cCode, cName FROM course";
	public static final String VIEW_PROFESSOR_QUERY = "SELECT department, designation FROM professor";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "SELECT userId, userName, branch FROM student JOIN user WHERE approved = 0";

}
