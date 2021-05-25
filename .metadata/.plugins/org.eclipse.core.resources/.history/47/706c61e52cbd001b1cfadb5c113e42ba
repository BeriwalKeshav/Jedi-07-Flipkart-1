/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ankit
 *
 */
public class CourseNotOfferedException extends Exception{
	private String cCode;
	
		public CourseNotOfferedException(String cCode)
		{	
			this.cCode = cCode;
		}		
		/**
		 * Message thrown by exception
		 */
		@Override
		public String getMessage() 
		{
			return "Course with courseCode: " + cCode + " can not be deleted.";
		}

}
