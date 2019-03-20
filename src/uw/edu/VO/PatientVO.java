package uw.edu.VO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class PatientVO {
	/*
	 * This class contains all the attributes of patient 
	 */
	private String id;
	private String name;
	private String age;
	private String insurance;
	private String address;
	private int height;
	private double weight;
	private String gender;
	
	/*
	 * Constructor. 
	 * Id is set to "NOT_DEFINED" in case of empty 
	 * results from DB.
	 */
	public PatientVO() {
		this.id = "NOT_DEFINED";
	}
	
	public PatientVO(String id) {
		this.id = id;
	}
	 
	@XmlElement
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@XmlElement
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@XmlElement
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@XmlElement
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	@XmlElement
	public String getInsurance() {
		return insurance;
	}
	
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	@XmlElement
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
