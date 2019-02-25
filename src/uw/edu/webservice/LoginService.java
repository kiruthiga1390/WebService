package uw.edu.webservice;

import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uw.edu.VO.UserVO;
import uw.edu.controller.LoginController;

@Path("/WebService")
public class LoginService {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("username") String username,
			@FormParam("password") String password) throws URISyntaxException {

		boolean flag = getAllUsersList(username, password);
		if (flag) { 
			java.net.URI location = new java.net.URI("../HTML/Home.html");
		    return Response.temporaryRedirect(location).build(); 
        } else { 
        	java.net.URI location = new java.net.URI("../HTML/Error.html");
		    return Response.temporaryRedirect(location).build(); 
        } 

	}

	public boolean getAllUsersList(String username, String password) {
		try {
			ArrayList<UserVO> userList = null;
			LoginController lc = new LoginController();
			userList = lc.getAllUsersList();
			for (UserVO userVO : userList) {
				if (userVO.getUsername().equals(username)) {
					if (userVO.getPassword().equals(password)) {
						return true;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return false;
	}
	
	
}
