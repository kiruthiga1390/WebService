package uw.edu.controller;
import uw.edu.VO.PatientHistoryVO;
import uw.edu.connection.ConnectMySQL;

public class PatientHistoryController {
	public PatientHistoryVO getPatientHistory(String patientId)throws Exception {
		PatientHistoryVO patient = null;
		try {
		ConnectMySQL db =new ConnectMySQL();
		patient= db.getPatientHistory(patientId);
		} catch (Exception e) {
		throw e;
		}
		return patient;
		}

}
