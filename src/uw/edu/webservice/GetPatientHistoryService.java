package uw.edu.webservice;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//import uw.edu.VO.PatientVO;
//import uw.edu.controller.PatientDetailController;




import uw.edu.VO.BillingVO;
import uw.edu.VO.PatientHistoryVO;
import uw.edu.controller.PatientHistoryController;

@Path("/WebService")
public class GetPatientHistoryService {
	@GET
	@Path("/getpatienthistory")
	@Produces(MediaType.APPLICATION_XML)
	
	public PatientHistoryVO patient( @QueryParam("patientId") String patientId)  {
        //System.out.println("Inside get method"+patientId);
		PatientHistoryVO patient = getPatientHistory(patientId);
		return patient;
		

	}
	public PatientHistoryVO getPatientHistory(String patientId) {
		PatientHistoryVO patient = null;
		try {
			PatientHistoryController pc = new PatientHistoryController();
			patient = pc.getPatientHistory(patientId);
			

		} catch (Exception e) {
			System.out.println("error");
		}
		return patient;
		
	}

}
