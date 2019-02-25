package uw.edu.webservice;

import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
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
public class GetPatientDetailService {
	@GET
	@Path("/getpatientdetails")
	@Produces(MediaType.APPLICATION_XML)
	public PatientVO patient( @QueryParam("patientId") String patientId)  {
        System.out.println("Inside get method"+patientId);
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

}
