/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constants.SQLQueriesConstanst;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;

/**
 * @author JEDI - 7
 *
 */
public class RegistrationDAOImpl implements RegistrationDAOInterface{

	@Override
	public boolean addCourse(String courseCode, int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dropCourse(String cCode, String studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewCourses(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		List<Course> availableCourseList = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		
		try 
		{
			PreparedStatement preaparedstatement = connection.prepareStatement(SQLQueriesConstanst.VIEW_AVAILABLE_COURSES);
			preaparedstatement.setString(1, studentId);
			preaparedstatement.setBoolean(2, true);
			ResultSet rs = preaparedstatement.executeQuery();

			while (rs.next()) {
				availableCourseList.add(new Course(rs.getString("cCode"), rs.getString("cName"),
						rs.getString("instructor"), rs.getBoolean("isoffered")));

			}
			

		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
//			preaparedstatement.close();
//			connection.close();
		}
		
		return availableCourseList;
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateFee(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean seatAvailable(String courseCode) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numOfRegisteredCourses(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRegistered(String courseCode, int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegistrationStatus(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
