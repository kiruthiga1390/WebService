package uw.edu.VO;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")

public class PatientHistoryVO {
	private String id;
	private String admissiondate;
	private String dischargeDate;
	private String treatementName;
	private String medicine ;
	private String dosage;
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getadmissiondate() {
		return admissiondate;
	}
	public void setadmissiondate(String admissionDate) {
		this.admissiondate = admissionDate;
	}
	@XmlElement
	public String getdischargeDate() {
		return dischargeDate;
	}
	public void setdischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	@XmlElement
	public String gettreatementName() {
		return treatementName;
	}
	public void settreatementName(String treatementName) {
		this.treatementName= treatementName;
	}
	@XmlElement
	public String getmedicine() {
		return medicine;
	}
	public void setmedicine(String medicine) {
		this.medicine = medicine;
	}
	@XmlElement
	public String getdosage() {
		return dosage;
	}
	public void setdosage(String dosage) {
		this.dosage = dosage;
	}

}
