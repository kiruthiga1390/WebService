package uw.edu.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uw.edu.VO.PatientVO;
import uw.edu.controller.PatientDetailController;

@Path("/WebService")
/*
 * This web service handles  the functionality of generating diet plan based on patient BMI
 */

public class GetDietPlanService {
	
	@GET
	@Path("/generatediet")
	@Produces(MediaType.APPLICATION_JSON)
	public String getdiet(@QueryParam("patientId") String patientId) throws IOException {
		PatientDetailService ps = new PatientDetailService();
         PatientVO patient = ps.getPatientDetails(patientId);
         String gender = patient.getGender();
         int age = Integer.parseInt(patient.getAge());
         int height = patient.getHeight();
         double weight = patient.getWeight();
         
         double bmi = getBMI(gender, age, height, weight);
         //System.out.println(bmi);
         String recipies = getRecepies(bmi);
         return recipies;
	}

	
	public String getRecepies(double bmi) throws IOException {
		String calorieType = "";
        if(bmi < 18.5) {
       	 calorieType = "high+calorie";	 
        } else if (bmi  < 25) {
       	 calorieType = "protein+fiber";
        } else if (bmi  < 30) {
       	 calorieType = "low+calorie";
        } else {
       	 calorieType = "low+calorie+high+fiber";
        }
        String urlstr = "https://edamam-recipe-search.p.rapidapi.com/search?r=lunch&q=" + calorieType;
        URL url = new URL(urlstr);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("GET"); 
        http.setRequestProperty("Content-Type", "application/json");
        http.setRequestProperty("X-RapidAPI-Key", "AlSZLBoYBwmshg76luVGDYutcxyKp1q1aeOjsnPe9aIEdpQBWM"); 
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//System.out.println("response is"+response.toString());
		
		return response.toString();
		
	}

	public double getBMI(String gender, int age, int height, double weight) throws IOException{
		String urlstr = "https://www.livestrong.com/service/Tools/Bmi/?units=kilograms&gender=" + gender + "&age=" + age +"&height=" + height + "&inches=&weight=" + weight;
        URL url = new URL(urlstr);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("GET"); 
        http.setRequestProperty("Content-Type", "application/json");
        //http.setDoOutput(true);  
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject jobj = new Gson().fromJson(response.toString(), JsonObject.class);
		return jobj.get("bmi").getAsDouble();
	}
	


}
