/**
 * 
 */
package com.flipkart.exception;

/**Exception to check if Professor is added to database or not.
 * @author prafu
 *
 */
public class ProfessorAdditionFailedException extends Exception{
	
	private String proffuserName;

	/**
	 * @param proffId
	 */
	public ProfessorAdditionFailedException(String proffId) {
		this.proffuserName = proffId;
	}

	/**
	 * @return the proffId
	 */
	public String getProffId() {
		return proffuserName;
	}
	
	@Override
	public String getMessage() {
		return "Can not add professor " + proffuserName + " to database";
	}

}
