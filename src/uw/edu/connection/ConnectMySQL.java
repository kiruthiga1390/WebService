package uw.edu.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uw.edu.VO.UserVO;
import uw.edu.VO.PatientHistoryVO;
import uw.edu.VO.PatientVO;

public class ConnectMySQL {
	private Connection connection = null;
	private ResultSet rs = null;
	private Statement st = null;
	
	String connectionURL = "jdbc:mysql://localhost:3306/patientmonitoring";
	
	private void createconnection() {
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root",
			    "root");

		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}

	}
	public Connection getConnection() {
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root",
			    "root");


		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		return connection;

	}
	
	public void closeconnection() {
		try {
			if (st != null) {
			st.close();
			}
			if (rs != null) {
				rs.close();
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Exception" + e);
		}
	}
	
	//get all users from database - users table
	public ArrayList<UserVO> getAllUsers()
			throws Exception {
		ArrayList<UserVO> userList = new ArrayList<UserVO>();
		try {
			Connection c = getConnection();
			// String uname = request.getParameter("uname");
			PreparedStatement ps = c
					.prepareStatement("SELECT * FROM users");
			// ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserVO uservo = new UserVO();
				uservo.setUsername(rs.getString("username"));
				uservo.setPassword(rs.getString("password"));
				userList.add(uservo);
			}
			closeconnection();
			return userList;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//get all users from database - patient table
		public PatientVO  getPatientDetails(String patientId)
				throws Exception {
			//System.out.println("Inside get patient details");
			PatientVO patient = new PatientVO();
			try {
				Connection c = getConnection();
				
				PreparedStatement ps = c
						.prepareStatement("SELECT * FROM patients where id= ?");
				ps.setString(1,patientId);
				//System.out.println("stmt is"+ps);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
				//System.out.println("name is"+rs.getString("name"));
				patient.setName(rs.getString("name"));
				patient.setAge(rs.getString("age"));	
				patient.setInsurance(rs.getString("insurance"));	
				patient.setAddress(rs.getString("address"));
				patient.setId(rs.getString("id"));
				}
				closeconnection();
				return patient;
				
			} catch (Exception e) {
				throw e;
			}
		}
		
		//add new  patient into database - patient table
				public void  addNewPatient(PatientVO patient)
						throws Exception {
					//System.out.println("Inside get patient details");
					//System.out.println(" database name is:"+patient.getName());
					try {
						Connection c = getConnection();
						
						String query = "insert into patients (id, name, age, insurance, address)"
						        + " values (?, ?, ?, ?, ?)";
						
						PreparedStatement ps = c
								.prepareStatement(query);
						ps.setString(1,patient.getId());
						ps.setString(2,patient.getName());
						ps.setString(3,patient.getAge());
						ps.setString(4,patient.getInsurance());
						ps.setString(5,patient.getAddress());
						//System.out.println("stmt is"+ps);
						ps.execute();
						closeconnection();
						
					} catch (Exception e) {
						throw e;
					}
				}

				//get patient history users from database - patient table
				public PatientHistoryVO  getPatientHistory(String patientId)
						throws Exception {
					//System.out.println("Inside get patient details");
					PatientHistoryVO patient = new PatientHistoryVO();
					try {
						Connection c = getConnection();
						
						PreparedStatement pss = c
								.prepareStatement("SELECT * FROM patienthistory where id= ?");
						pss.setString(1,patientId);
						//System.out.println("stmt is"+ps);
						ResultSet rsd = pss.executeQuery();
						while(rsd.next()){
						//System.out.println("name is"+rs.getString("name"));
						patient.setId(rsd.getString("id"));	
						patient.setadmisiondate(rsd.getString("admisiondate"));
						patient.setdischargeDate(rsd.getString("dischargeDate"));	
						patient.settreatementName(rsd.getString("treatmentName"));	
						patient.setmedicine(rsd.getString("medicine"));
						patient.setdosage(rsd.getString("dosage"));
					
						}
						closeconnection();
						return patient;
						
					} catch (Exception e) {
						throw e;
					}
				}

}
