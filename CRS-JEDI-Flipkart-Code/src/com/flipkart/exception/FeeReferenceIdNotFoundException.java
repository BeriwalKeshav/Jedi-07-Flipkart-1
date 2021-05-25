/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-07
 *
 */
public class FeeReferenceIdNotFoundException {
	private String feePaymentId;
	
	public void FeeReferenceIdNotFoundException(String feePaymentId) {
		this.feePaymentId = feePaymentId;
	}
	
	public String getMessage() {
		return "Payment ID " + this.feePaymentId + " not found";
	}
}
