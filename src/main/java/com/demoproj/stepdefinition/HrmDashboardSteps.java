package com.demoproj.stepdefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demoproj.pages.HrmDashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HrmDashboardSteps {
	//Page Object
	HrmDashboard hdb = new HrmDashboard();
	

	//Step Definitions
	@Then("the user navigated to the dashboard page")
	public void the_user_land_on_the_dashboard_page() {
		try {
			hdb.waitForPageLoad();
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
	@When("user clicks the stop watch icon under Time at Work card")
	public void user_clicks_the_stop_watch_icon() {
		try {
			hdb.clickStopWatchButton();
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
}
