/**
 * 
 */
package com.flipkart.exception;

/**
 * @author ankit
 *
 */
public class CourseNotInCatalogException extends Exception{
	private String cCode;
	
		public CourseNotInCatalogException(String cCode)
		{	
			this.cCode = cCode;
		}		
		/**
		 * Message thrown by exception
		 */
		@Override
		public String getMessage() 
		{
			return "Course with courseCode: " + cCode + " can not be offered to student.";
		}
}
