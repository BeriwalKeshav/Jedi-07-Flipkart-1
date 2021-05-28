/**
 * 
 */
package com.flipkart.restController;

import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.flipkart.service.RegistrationInterface;
import com.flipkart.service.RegistrationOperation;
import com.flipkart.bean.Course;

/**
 * @author prafu
 *
 */

@Path("/student")
public class StudentRESTApi {
	
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	
	/**
	 * Method to viewAvailableCourses 
	 * @param studentId
	 * @return
	 * @throws ValidationException
	 */
	@GET
	@Path("/viewAvailableCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> viewCourse(
			@NotNull
			@QueryParam("studentId") String studentId) {
		
		System.out.println(studentId);
		try {
			return registrationInterface.viewCourses(studentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/*
	@POST
	@Path("/viewAvailableCourses2")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewCourse2(String studentId, List<String> courseList) {
		
		System.out.println(studentId + courseList);
		return Response.status(201).entity("Your total fee  = "+ studentId + courseList).build();
		
	}
	*/
	
}
