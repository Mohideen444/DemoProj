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

public class HrmDashboard {
	//Locators
	By stopwatch_button = By.xpath("//button[contains(@class,\"orangehrm-attendance-card-action\")]");
	
	
	//Getters
	UrlInfo info;
	
	//Wait
	int wait = GlobalConfiguration.getInstance().getExplicit_wait_time();
	
	//Log
	Logger log = LoggerFactory.getLogger(getClass());
	
	//Library object
	WebDriverCommons commons = WebDriverSetup.getInstance().getWebDriverCommons();
	
	//Page Functions
	public void waitForPageLoad() throws FileIsNotPresent, IOException, ParseException {
		info = new UrlInfo();
		String url = info.getHrmUrls("dashboard");
		commons.waitForUrlToBe(url, wait);
		log.info("Navigated to the Orange HRM Dashboard : "+url);
	}
	
	public void clickStopWatchButton() throws FileIsNotPresent, IOException, ParseException {
		commons.waitForPresenceOfElement(stopwatch_button, wait);
		WebElement ele = commons.findElement(stopwatch_button);
		ele.click();
		log.info("Stopwatch button clicked");
	}
	
}
