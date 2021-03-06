package uw.edu.controller;

import uw.edu.VO.PatientVO;
import uw.edu.connection.ConnectMySQL;

public class PatientDetailController {
	/* Handles all patient details like getting patient details and adding new patient details
	 * updating and deleting existing patient details.
	 * 
	 */
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
	
	public void addNewPatient(PatientVO patient)throws Exception {
		try {
			//System.out.println(" controller name is:"+patient.getName());
			ConnectMySQL db =new ConnectMySQL();
			db.addNewPatient(patient);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void updatePatient(PatientVO patient) throws Exception {
		try {
			ConnectMySQL db = new ConnectMySQL();
			db.updatePatientInfo(patient);
		} catch (Exception ex) {
			throw ex;
		}	
	}
	
	public void deletePatient(PatientVO patient) throws Exception {
		ConnectMySQL db = new ConnectMySQL();
		db.deletePatient(patient);
	}
}
