package com.demoproj.pages;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demoproj.getters.UrlInfo;
import com.demoproj.library.WebDriverCommons;
import com.demoproj.library.FileHandler.FileHandlerException.FileIsNotPresent;
import com.demoproj.setup.GlobalConfiguration;
import com.demoproj.setup.WebDriverSetup;

public class HrmAttendance {
	//Locators
	By out_button = By.xpath("//button[contains(@class,'orangehrm-left-space')]");
	By text_area = By.xpath("//textarea[@placeholder=\"Type here\"]");
	By success_toast = 
			By.xpath("//div[contains(@class,'oxd-toast-content--success')]/p[contains(@class,'toast-title')]");
	
	//Getters
	UrlInfo info;
	
	//Wait
	int wait = GlobalConfiguration.getInstance().getExplicit_wait_time();
	
	//Log
	Logger log = LoggerFactory.getLogger(getClass());
	
	//Library object
	WebDriverCommons commons = WebDriverSetup.getInstance().getWebDriverCommons();
	
	
	public void waitForPunchoutPage() throws FileIsNotPresent, IOException, ParseException {
		info = new UrlInfo();
		String url = info.getHrmUrls("punchout");
		commons.waitForUrlToBe(url, wait);;
		log.info("Navigated to the Orange HRM Punchout page : "+url);
	}
	
	public void enterPunchOutNotes(String notes)
	{
		commons.waitForPresenceOfElement(text_area, wait);
		WebElement ele = commons.findElement(text_area);
		ele.sendKeys(notes);
		log.info("Entered the puchout notes as : "+ notes);
	}
	
	public void clickPunchOutButton()
	{
		WebElement ele = commons.findElement(out_button);
		ele.click();
		log.info("Punchout button clicked");
	}
	
	public String verifySuccessfulPunchout() {
		commons.waitForPresenceOfElement(success_toast, wait);
		WebElement ele = commons.findElement(success_toast);
		String message = ele.getText();
		log.info("Punched out Successfully");
		return message;
	}
	
	
	
	
	
}
