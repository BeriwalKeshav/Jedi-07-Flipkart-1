package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.flipkart.bean.Notification;

//import com.flipkart.constant.ModeOfPayment;
//import com.flipkart.constant.NotificationType;


/*
 * @author JEDI-07
 * */

public interface NotificationInterface {
	
	/**
	 * Method to send notification
	 * @param referenceId: Payment Id
	 * @param studentId: student to be notified
	 * @param message: Message to be sent
	 * @return notification id for the record added in the database
	 */
	public String sendNotification(String message,String studentId,String referenceId);
	
	/**
	 * Method to return UUID for a transaction
	 * @param id: notification id added in the database
	 * @return transaction id of the payment
	 */
	public String getReferenceId(String id); 
	public List<Notification> getAllNotifications(String StudentId) throws SQLException;
}