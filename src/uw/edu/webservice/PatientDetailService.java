package uw.edu.webservice;

import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public String patient(@FormParam("id") String id,
			@FormParam("name") String name,@FormParam("age") String age,@FormParam("address") String address,@FormParam("insurance") String insurance)  {
        //System.out.println("Inside get method"+patientId);
		PatientVO patient = new PatientVO();
		patient.setId(id);
		patient.setAddress(address);
		patient.setAge(age);
		patient.setInsurance(insurance);
		patient.setName(name);
		
		String output = addNewPatient(patient);
		
		return output;

	}
	
	public String addNewPatient(PatientVO patient){
		
		try {
			//System.out.println(" web service name is:"+patient.getName());
			PatientDetailController pc = new PatientDetailController();
			pc.addNewPatient(patient);	

		} catch (Exception e) {
			//System.out.println(e.getMessage());
			System.out.println("Patient details are not added.Please try again");
		}
		return "Patient Details are added Successfully";
		
	}
	

}
