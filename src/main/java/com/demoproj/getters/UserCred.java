package com.demoproj.getters;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.demoproj.enums.ProjectStructure;
import com.demoproj.library.FileHandler;
import com.demoproj.library.FileHandler.FileHandlerException.FileIsNotPresent;
import com.demoproj.library.JSONFileHandler;
import com.demoproj.setup.GlobalConfiguration;
import com.demoproj.setup.GlobalPaths;

public class UserCred {
	
	GlobalPaths globalPaths = new GlobalPaths();
	JSONFileHandler jsonFileHandler;
	
	String user_cred_path = ProjectStructure.pathToProject.toString()
			+globalPaths.getFile_separator()
			+ProjectStructure.testdata.toString()
			+globalPaths.getFile_separator()
			+globalPaths.getEnv()
			+globalPaths.getFile_separator()
			+"user-cred.json";
	
    public UserCred() throws FileIsNotPresent, IOException, ParseException {
        jsonFileHandler = new JSONFileHandler(user_cred_path).parseObject("user");
    }

	
	public String getUserName(String userType) throws FileHandler.FileHandlerException.FileIsNotPresent, IOException, ParseException
	{
		return jsonFileHandler
				.parseObject(userType)
				.parseObject("username").toString();
	}
	
	public String getPassword(String userType) throws FileHandler.FileHandlerException.FileIsNotPresent, IOException, ParseException
	{
		return jsonFileHandler
				.parseObject(userType)
				.parseObject("password").toString();
	}
	
	
	public static void main(String[] args) throws FileHandler.FileHandlerException.FileIsNotPresent, IOException, ParseException {
		GlobalConfiguration.init();
		UserCred u = new UserCred();
		String n = u.getUserName("admin");
		String p = u.getPassword("admin");
		System.out.println("The user name is : \"" +n+ "\" and the password is : "+p);
	}
	
}
