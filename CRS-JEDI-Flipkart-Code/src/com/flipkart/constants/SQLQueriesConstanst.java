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
	public static final String GET_USER_ROLE = "SELECT role FROM user WHERE userName = ?";
	public static final String UPDATE_USER_PASSWORD = "UPDATE user SET passwordHash = ? WHERE userName = ?";
	
}
