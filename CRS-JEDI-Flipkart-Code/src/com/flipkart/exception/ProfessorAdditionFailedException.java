/**
 * 
 */
package com.flipkart.exception;

/**Exception to check if Professor is added to database or not.
 * @author prafu
 *
 */
public class ProfessorAdditionFailedException extends Exception{
	
	private String proffId;

	/**
	 * @param proffId
	 */
	public ProfessorAdditionFailedException(String proffId) {
		this.proffId = proffId;
	}

	/**
	 * @return the proffId
	 */
	public String getProffId() {
		return proffId;
	}
	
	@Override
	public String getMessage() {
		return "Can not add professor " + proffId + " to database";
	}

}
