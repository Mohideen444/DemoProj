
  package com.demoproj.pages;
  
  import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.demoproj.getters.UserCred;
import com.demoproj.library.FileHandler.FileHandlerException.FileIsNotPresent;
  
  public class FacadeComponents {
  
  // Facade is a design pattern for combining multiple functions into a single unit to use it on different places. 
  // So In this class I combined steps as a reusable single function to reduce the scenario length
  
  //Pages
	  HrmLogin login = new HrmLogin();
	  
	  UserCred cred;

	//Constructor
	public FacadeComponents() throws FileIsNotPresent, IOException, ParseException {
		cred = new UserCred();
	}
  
  public void loginToOrangeHRM(String type) throws FileIsNotPresent, IOException, ParseException {
	  login.goToPage();
	  String user = cred.getUserName(type);
	  login.enterUserName(user);
	  String password = cred.getPassword(type);
	  login.enterPassword(password);
	  login.clickLoginButton();
	 
  }
  
  
  
  
  
  }
 