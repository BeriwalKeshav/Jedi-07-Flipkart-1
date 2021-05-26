/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;
import java.util.UUID;


/**
 * @author JEDI-07
 *
 */
public interface NotificationDAOInterface {

	/**
	 * Send Notification using SQL commands
	 * @param message: Message to be sent
	 * @param studentId: student to be notified
	 * @param referenceId: ID for the transaction
	 * @return notification id for the notification added in the database
	 * @throws SQLException
	 */
	public String sendNotification(String message,String studentId,String referenceId) throws SQLException;
	public String getReferenceId(String notificationId) throws SQLException;
}
