package uw.edu.controller;

import java.util.ArrayList;

import uw.edu.VO.UserVO;
import uw.edu.connection.ConnectMySQL;

public class LoginController {

	public ArrayList<UserVO> getAllUsersList()throws Exception {
		ArrayList<UserVO> userList = null;
		try {
		ConnectMySQL db =new ConnectMySQL();
		userList= db.getAllUsers();

		} catch (Exception e) {
		throw e;
		}
		return userList;
		}

}
