package com.demoproj.stepdefinition;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.demoproj.getters.UserCred;
import com.demoproj.library.FileHandler.FileHandlerException.FileIsNotPresent;
import com.demoproj.pages.HrmLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HrmLoginSteps {

	//Page Object
	HrmLogin login = new HrmLogin();
	UserCred cred;

	//Constructor
	public HrmLoginSteps() throws FileIsNotPresent, IOException, ParseException {
		cred = new UserCred();
	}
	
	
	//Step Definitions
	@Given("user navigates to the orange hrm login page")
	public void user_navigates_to_orange_hrm_login_page() {
		try {
			login.goToPage();
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
	@And("user enters valid {string} user name")
	public void user_enters_valid_user_name(String type) throws FileIsNotPresent, IOException, ParseException
	{
		try {
		String user = cred.getUserName(type);
		login.enterUserName(user);
		}catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
	@And("user enters valid {string} password")
	public void user_enters_valid_password(String type) throws FileIsNotPresent, IOException, ParseException
	{
		try {
		String password = cred.getPassword(type);
		login.enterPassword(password);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@When("user clicks the login button")
	public void user_clicks_the_login_button() throws FileIsNotPresent, IOException, ParseException
	{	
		try {
		login.clickLoginButton();
		}
		catch (Throwable e) {
	    	e.printStackTrace();
		}
	}
	
	@And("user enters invalid {string} user name")
	public void enter_invalid_username(String userName)
	{	
		try {
		login.enterUserName(userName);
		}
		catch (Throwable e) {
	    	e.printStackTrace();
		}
	}
	
	@And("user enters invalid {string} password")
	public void enter_invalid_password(String password)
	{	
		try {
		login.enterPassword(password);
		}
		catch (Throwable e) {
	    	e.printStackTrace();
		}
	}
	
	@And("the user gets {string} error message")
	public void user_gets_invalid_cred_error(String errorExpected)
	{	
		try {
		String actualError = login.verifyLoginError();
		
		Assert.assertEquals(actualError, errorExpected);
		}
		catch (Throwable e) {
	    	e.printStackTrace();
	    	Assert.fail();
		}
	}
}
