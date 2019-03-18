package uw.edu.VO;

public class VitalSignVO {
	
	private String patient_id;
	private int pulse_rate;
	private int pressure_diastolic;
	private double temperature;
	private int pressure_systolic;
	private int respiration_rate;
	private String caretaker_no;
	
	
	public String getCaretaker_no() {
		return caretaker_no;
	}
	public void setCaretaker_no(String caretaker_no) {
		this.caretaker_no = caretaker_no;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public int getPulse_rate() {
		return pulse_rate;
	}
	public void setPulse_rate(int pulse_rate) {
		this.pulse_rate = pulse_rate;
	}
	public int getPressure_diastolic() {
		return pressure_diastolic;
	}
	public void setPressure_diastolic(int pressure_diastolic) {
		this.pressure_diastolic = pressure_diastolic;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getPressure_systolic() {
		return pressure_systolic;
	}
	public void setPressure_systolic(int pressure_systolic) {
		this.pressure_systolic = pressure_systolic;
	}
	public int getRespiration_rate() {
		return respiration_rate;
	}
	public void setRespiration_rate(int respiration_rate) {
		this.respiration_rate = respiration_rate;
	}
	
	
	

}
