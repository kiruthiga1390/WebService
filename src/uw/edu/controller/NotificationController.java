package uw.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import uw.edu.VO.PatientVO;
import uw.edu.VO.VitalSignVO;
import uw.edu.connection.ConnectMySQL;
import uw.edu.webservice.SMSNotificationService;

public class NotificationController {
	

	public void getVitalSigns()throws Exception {
		List<VitalSignVO> vitalSignList = null;
		try {
		ConnectMySQL db =new ConnectMySQL();
		vitalSignList =new ArrayList<VitalSignVO>();
		vitalSignList= db.getVitalSign();
		CheckVitalSigns(vitalSignList);
		} catch (Exception e) {
		throw e;
		}
		}
	
	
	public void CheckVitalSigns(List<VitalSignVO> vitalList){
		boolean flag = false;
		String message = null;
		
		for (VitalSignVO vital:vitalList){
			String patient_id = vital.getPatient_id();
			int pulse = vital.getPulse_rate();
			int pressure_diastolic = vital.getPressure_diastolic();
			int pressure_systolic = vital.getPressure_systolic();
			double temperature = vital.getTemperature();
			int resp_rate=vital.getRespiration_rate();
			
			if (pulse <60 || pulse >100){
				flag = true;
				message = "Patient"+patient_id +"is critical.Pulse rate is abnormal";
			}else if(pressure_systolic >120 ){
				flag = true;
				message = "Patient"+patient_id +"is critical.Systolic blood pressure is abnormal";
			}else if(pressure_systolic >120 ){
				flag = true;
				message = "Patient"+patient_id +" is critical.Systolic blood pressure is abnormal";
			}
			else if(pressure_diastolic <80 ){
				flag = true;
				message = "Patient"+patient_id +" is critical.Diastolic blood pressure is abnormal";
			}
			else if(temperature >98.6 || temperature < 95 ){
				flag = true;
				message = patient_id +"Temperature is abnormal";
			}
			else if(resp_rate >12 || resp_rate < 16 ){
				flag = true;
				message = "Patient"+ patient_id +" is critical.Respiration rate is abnormal";
			}
			
			if (flag){
				SMSNotificationService notifyservice = new SMSNotificationService();
				notifyservice.sendNotification(message);
			}
			
		}
		
	}

}
