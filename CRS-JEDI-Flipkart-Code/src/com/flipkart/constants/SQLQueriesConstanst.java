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
	
}
