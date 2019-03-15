package uw.edu.controller;

import uw.edu.VO.BillingVO;
import uw.edu.connection.ConnectMySQL;

public class PatientBillingController {
	public BillingVO getPatientBilling(String patientId)throws Exception {
		BillingVO billing = null;
		try {
		ConnectMySQL db =new ConnectMySQL();
		billing= db.getPatientBilling(patientId);
		} catch (Exception e) {
		throw e;
		}
		return billing;
		}
}
