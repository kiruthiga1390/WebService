package uw.edu.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import uw.edu.VO.BillingVO;
import uw.edu.controller.PatientBillingController;


@Path("/WebService")
/*
 * This web service handles  the functionality of generating billing details based on patient's RFID
 */

public class GetPatientBillingSerice {
	
	@GET
	@Path("/getbilling")
	@Produces(MediaType.APPLICATION_JSON)
	
	public BillingVO patientbilling( @QueryParam("patientId") String patientId)  {
        //System.out.println("Inside get billing method:"+patientId);
		BillingVO billing = getPatientBilling(patientId);
		return billing;
		

	}
	public BillingVO getPatientBilling(String patientId) {
		BillingVO billing = null;
		try {
			PatientBillingController pc = new PatientBillingController();
			billing = pc.getPatientBilling(patientId);
			

		} catch (Exception e) {
			System.out.println("error");
		}
		return billing;
		
	}
	
	

}
