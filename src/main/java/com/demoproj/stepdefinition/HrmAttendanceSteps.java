package com.demoproj.stepdefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.demoproj.pages.HrmAttendance;
import com.demoproj.pages.HrmDashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HrmAttendanceSteps {
	
	//Page Object
	HrmAttendance attendance = new HrmAttendance();
	

	//Step Definitions
	@Then("user redirects to the attendance page")
	public void user_land_on_the_attendance_page() {
		try {
			attendance.waitForPunchoutPage();
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
	@When("user enters the puchout notes")
	public void user_enters_the_puchout_notes() {
		try {
			attendance.enterPunchOutNotes("test notes");
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
	@And("the user clicks on out button")
	public void user_clicks_on_out_button() {
		try {
			attendance.clickPunchOutButton();
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
	@Then("the user punched out successfully")
	public void user_punched_out_successfully() {
		try {
			String expected = "Success";
			String text = attendance.verifySuccessfulPunchout();
			Assert.assertEquals(text, expected);
	    } catch (Throwable e) {
	    	e.printStackTrace();
	    }
	}
	
}
