package uw.edu.webservice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.Errors.ErrorMessage;

import uw.edu.VO.PatientVO;
import uw.edu.controller.PatientDetailController;

@Path("/WebService")
public class PatientDetailService {
	@GET
	@Path("/getpatientdetails")
	@Produces(MediaType.APPLICATION_XML)
	public PatientVO patient( @QueryParam("patientId") String patientId)  {
        //System.out.println("Inside get method"+patientId);
		PatientVO patient = getPatientDetails(patientId);
		return patient;
		

	}
	
	public PatientVO getPatientDetails(String patientId) {
		PatientVO patient = null;
		try {
			PatientDetailController pc = new PatientDetailController();
			patient = pc.getPatientDetails(patientId);
			

		} catch (Exception e) {
			System.out.println("error");
		}
		return patient;
		
	}
	
	@POST
	@Path("/addpatientdetails")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response patient(@FormParam("id") String id,
			@FormParam("name") String name,@FormParam("age") String age,@FormParam("address") String address,@FormParam("insurance") String insurance,
			@FormParam("gender") String gender,@FormParam("height") int height,@FormParam("weight") double weight) throws URISyntaxException  {
        //System.out.println("Inside get method"+patientId);
		PatientVO patient = new PatientVO();
		patient.setId(id);
		patient.setAddress(address);
		patient.setAge(age);
		patient.setInsurance(insurance);
		patient.setName(name);
		patient.setGender(gender);
		patient.setHeight(height);
		patient.setWeight(weight);
		
		boolean flag = addNewPatient(patient);
		
		if (flag) { 
			java.net.URI location = new java.net.URI("../HTML/PatientSuccess.html");
		    return Response.temporaryRedirect(location).build(); 
        } else { 
        	java.net.URI location = new java.net.URI("../HTML/Error.html");
		    return Response.temporaryRedirect(location).build(); 
        } 
		

	}

	public boolean addNewPatient(PatientVO patient){

		
		try {
			//System.out.println(" web service name is:"+patient.getName());
			PatientDetailController pc = new PatientDetailController();
			pc.addNewPatient(patient);	

		} catch (Exception e) {
			//System.out.println(e.getMessage());
			System.out.println("Patient details are not added.Please try again");
			return false;
		}

		return true;

	}
	


	@PUT
	@Path("/updatepatientdetails")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(@FormParam("id") String id,
			@FormParam("age") String age,
			@FormParam("address") String address,
			@FormParam("insurance") String insurance,@FormParam("height") int height,@FormParam("weight") double weight) throws URISyntaxException {
        //System.out.println("Inside update method -> "+id + ".");
        if(id == null || id.isEmpty()) {
        	System.out.println("Failed! Input is null");
        	return buildErrorResponse("Input is null", "PatientUpdateError.html", Response.Status.BAD_REQUEST);
        }
        
		PatientVO patient = new PatientVO();
		patient.setId(id);
		patient.setAddress(address);
		patient.setAge(age);
		patient.setInsurance(insurance);
		patient.setHeight(height);
		patient.setWeight(weight);
		//System.out.println(String.format("Id=%s, name=%s, age=%s, address=%s", id, name, age,address));
		PatientDetailController pc = new PatientDetailController();
		try {
			pc.updatePatient(patient);
			java.net.URI location = new java.net.URI("../HTML/PatientUpdateSuccess.html");
		    return Response.temporaryRedirect(location).status(Response.Status.OK).build(); 
		} catch(Exception ex) {
			System.out.println(ex);
			return buildErrorResponse(ex.getMessage(), "PatientUpdateError.html", Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DELETE
	@Path("/deletepatient")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String delete(@FormParam("id") String id) {
		if(id == null || id.isEmpty()) {
			return "Failed! Input is null or empty";
		}
		
		PatientVO patient = new PatientVO();
		patient.setId(id);
		PatientDetailController pc = new PatientDetailController();
		try {
			pc.deletePatient(patient);
			return "Patient successfully deleted";
		} catch(Exception ex) {
			System.out.println(ex);
			return "Failed to delete patient";
		}
	}
	
	private Response buildErrorResponse(String errorMessage, String redirection, Response.Status status) 
			throws URISyntaxException {
		java.net.URI location = new java.net.URI("../HTML/" + redirection);
		return Response.temporaryRedirect(location)
				.status(status)
				.entity(errorMessage)
				.build();
	}
	
}
