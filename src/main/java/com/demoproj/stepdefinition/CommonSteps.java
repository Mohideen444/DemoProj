package com.demoproj.stepdefinition;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demoproj.library.FileHandler.FileHandlerException.FileIsNotPresent;
import com.demoproj.pages.FacadeComponents;

import io.cucumber.java.en.Given;

public class commonSteps {

	//Pages
	FacadeComponents components;
	
	//Log
	Logger log = LoggerFactory.getLogger(getClass());
	
	//Constructor
	public commonSteps() throws FileIsNotPresent, IOException, ParseException {
		components = new FacadeComponents();
	}
	
	//Step Definitions
	
	@Given("user successfully logged-in as {string} in the Orange HRM portal")
	public void the_user_logins_to_orange_hrm_portal(String type) {
		try {
			components.loginToOrangeHRM(type);
			log.info("Logged in to the orange HRM");
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
}
