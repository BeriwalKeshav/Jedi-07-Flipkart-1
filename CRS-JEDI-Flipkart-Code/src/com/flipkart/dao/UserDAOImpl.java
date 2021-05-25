/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constants.SQLQueriesConstanst;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;

/**
 * @author prafu
 *
 */
public class UserDAOImpl implements UserDaoInterface{

	@Override
	public boolean verifyCredentials(String userId, String password) throws UserNotFoundException {
		Connection connection = DBUtil.getConnection();
		try
		{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstanst.VERIFY_CREDENTIALS);
			preparedStatement.setString(1,userId);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
				return true;
			else{
				System.out.println("Current user is -> " + resultSet.getString("userName"));
				throw new UserNotFoundException(userId);
			}
		}
		catch(SQLException ex)
		{
			System.out.println("User credentials invalid! "+ ex.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	

}
