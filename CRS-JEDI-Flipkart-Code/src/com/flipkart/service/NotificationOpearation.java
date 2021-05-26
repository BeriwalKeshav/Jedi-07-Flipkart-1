/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDAOInterface;
import com.flipkart.dao.NotificationDAOOperation;

/**
 * @author JEDI-7
 *
 */
public class NotificationOpearation implements NotificationInterface{
	
	private static volatile NotificationOpearation instance = null;
	
	/**
	 * Default Constructor
	 */
	private NotificationOpearation()
	{

	}
	
	/**
	 * Method to make NotificationDAOOperation Singleton
	 * @return
	 */
	public static NotificationOpearation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(NotificationOpearation.class){
				instance=new NotificationOpearation();
			}
		}
		return instance;
	}
	
	NotificationDAOInterface notificationDAOInterface= NotificationDAOOperation.getInstance();
	
	/**
	 * Method to send notification
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: payment mode used
	 * @return notification id for the record added in the database
	 */
	@Override
	public String sendNotification(String message,String studentId,String referenceId) {
		String notificationId="";
		try
		{
			notificationId=notificationDAOInterface.sendNotification(referenceId,studentId,message);
			
		}
		catch(SQLException ex)
		{
			System.out.println("Error Occured :( " + ex.toString());
		}
		return notificationId;
	}
	
	@Override
	public String getReferenceId(String NotificationId) {
		String referenceId="";
		try {
			referenceId = notificationDAOInterface.getReferenceId(NotificationId);
		}
		catch(SQLException ex) {
			System.out.println("Error Occured :( " + ex.toString());
		}
		return referenceId;
	}

	@Override
	public List<Notification> getAllNotifications(String StudentId) throws SQLException {
		List<Notification> notifications = null;
		try {
			notifications = notificationDAOInterface.getAllNotifications(StudentId);
		} 
		catch(SQLException ex) {
			throw ex;
		}
		return notifications;
	}
	
}