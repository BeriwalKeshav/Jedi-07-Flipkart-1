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
	public static final String VIEW_AVAILABLE_COURSES = "select * from course where cCode not in  (select courseCode  from registered_courses where studentId = ?) and course.isOffered = ?";
	public static final String GET_USER_ROLE = "SELECT role FROM user WHERE userName = ?";
	public static final String UPDATE_USER_PASSWORD = "UPDATE user SET passwordHash = ? WHERE userName = ?";
	
	public static final String ADD_COURSE="insert into registered_courses (studentId,semester,courseCode) values ( ? , ? , ?)";
	public static final String DECREMENT_COURSE_SEATS="update course set courseSeats = courseSeats-1 where cCode = ? ";
	public static final String DROP_COURSE_QUERY = "delete from registered_courses where courseCode = ? AND studentId = ? AND semester = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update course set courseSeats = courseSeats + 1 where  cCode = ?;";
//	public static final String VIEW_AVAILABLE_COURSES=" select * from course where cCode not in  (select courseCode  from registered_courses where studentId = ?) and course.isOffered = ? and seats > 0";
	public static final String VIEW_GRADE = "select course.cCode,registered_courses.studentId,course.cName,registered_courses.grade from course inner join registered_courses on course.cCode = registered_courses.courseCode where registered_courses.studentId = ?;";
	
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
