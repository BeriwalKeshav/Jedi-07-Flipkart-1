package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import com.flipkart.utils.DBUtil;
import com.flipkart.bean.Notification;
import com.flipkart.constants.SQLQueriesConstanst;

/**
 * @author JEDI-07
 * Class to implement Notification Dao Operations
 * Used for adding the notification to the database
 * Used for getting the payment ID of the transaction using the notification ID
 * Recording the payments
 */

public class NotificationDAOOperation implements NotificationDAOInterface{
		
	/**
	 * Send Notification using SQL commands
	 * @param Message: Message to be sent 
	 * @param studentId: student to be notified
	 * @param referenceId: ReferenceId of the payment
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	@Override
	public String sendNotification(String Message, String StudentId, String ReferenceId) throws SQLException {
		String notificationId = "";
		Connection connection = DBUtil.getConnection();
		try {
			//Insert Notification
			notificationId = UUID.randomUUID().toString();
			PreparedStatement ps = connection.prepareStatement(SQLQueriesConstanst.INSERT_NOTIFICATION);
			ps.setString(1,notificationId);
			ps.setString(2,Message);
			ps.setString(3, StudentId);
			ps.setString(4, ReferenceId);
			
			ps.executeUpdate();
			ResultSet results = ps.getGeneratedKeys();
						
			System.out.println("Student with studentID" + StudentId + "has paid the fees!");
		}
		catch(SQLException ex) {
			throw ex;
		}
		return notificationId;
	}
	
	/**
	 * @param notificatinId - Id of the notification received by the user
	 * @return ReferenceId - Payment Id of the transaction
	 * @throws SQLException
	 * */
	@Override
	public String getReferenceId(String notificationId) throws SQLException{
		String referenceId;
		Connection connection = DBUtil.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstanst.GET_REFERENCE_ID);
			statement.setString(1, notificationId);
			statement.executeQuery();
			ResultSet results = statement.getGeneratedKeys();
			
			referenceId = results.getString(4);
		}
		catch(SQLException ex) {
			throw ex;
		}
		return referenceId;
	}
	
	/**
	 * Perform Payment actions using SQL commands
	 * @param studentId: Id of the student for which the payment is done
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount 
	 * @return: reference id of the transaction
	 * @throws SQLException
	 */
	public String addPayment(String StudentId,int amount,boolean status,String paymentType) throws SQLException {
		String referenceId;
		Connection connection = DBUtil.getConnection();
		
		try {
			referenceId = UUID.randomUUID().toString();
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstanst.INSERT_PAYMENT);
			statement.setString(1,StudentId);
			statement.setString(2,referenceId);
			statement.setInt(3, amount);
			statement.setBoolean(4, status);
			statement.setString(5, paymentType);
			statement.executeUpdate();
			// Here, a check database for update
		}
		catch(SQLException ex) {
			throw ex;
		}
		return referenceId;
	}

	@Override
	public List<Notification> getAllNotifications(String studentId) throws SQLException {
		// TODO Auto-generated method stub
		List<Notification> allnotifications = null;
		Connection connection = DBUtil.getConnection();
		
		try {
			//select * from notification where studentId=?
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstanst.GET_ALL_NOTIFICATIONS);
			statement.setString(1,studentId);
			statement.executeQuery();
			
			ResultSet results = statement.getGeneratedKeys();
			
			while(results.next()) {
				allnotifications.add(new Notification(results.getString("notificationId"), results.getString("studentId"), results.getString("message"), results.getString("referenceId")));
			}
		} 
		catch(SQLException ex) {
			throw ex;
		}
		
		return allnotifications;
	}
	
}
