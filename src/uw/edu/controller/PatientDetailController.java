package uw.edu.controller;

import uw.edu.VO.PatientVO;
import uw.edu.connection.ConnectMySQL;

public class PatientDetailController {
	public PatientVO getPatientDetails(String patientId)throws Exception {
		PatientVO patient = null;
		try {
		ConnectMySQL db =new ConnectMySQL();
		patient= db.getPatientDetails(patientId);
		} catch (Exception e) {
		throw e;
		}
		return patient;
		}
}
