/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;

import java.util.UUID;

import com.flipkart.dao.NotificationDAOInterface;
import com.flipkart.dao.NotificationDAOOperation;

/**
 * @author JEDI-7
 *
 */
public class NotificationOpearation implements NotificationInterface{
	
	NotificationDAOInterface notificationDAOInterface= new NotificationDAOOperation();
	
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
	
}
