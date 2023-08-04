package com.demoproj.pages;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demoproj.getters.UrlInfo;
import com.demoproj.getters.UserCred;
import com.demoproj.library.WebDriverCommons;
import com.demoproj.library.FileHandler.FileHandlerException.FileIsNotPresent;
import com.demoproj.setup.GlobalConfiguration;
import com.demoproj.setup.WebDriverSetup;

public class HrmLogin {
	
	//Locators
	By username_field = By.xpath("//input[@name='username']");
	By pwd_field = By.xpath("//input[@name='password']");
	By login_button = By.xpath("//button[contains(@class,'orangehrm-login-button')]");
	By login_error = By.xpath("//div[contains(@class,'oxd-alert-content--error')]/p");

	//Getters
	UrlInfo info= new UrlInfo();
	
	//Wait
	int pageload = GlobalConfiguration.getInstance().getWait_time();
	int wait = GlobalConfiguration.getInstance().getExplicit_wait_time();
	
	//Log
	Logger log = LoggerFactory.getLogger(getClass());
	
	//Library object
	WebDriverCommons commons = WebDriverSetup.getInstance().getWebDriverCommons();
	
	//Page Functions
	public void goToPage() throws FileIsNotPresent, IOException, ParseException {
		info = new UrlInfo();
		String url = info.getHrmUrls("login");
		commons.goTo(url);
		log.info("Navigated to the URL : "+url);
	}
	
	
	public void enterUserName(String user) throws FileIsNotPresent, IOException, ParseException
	{
		commons.waitForPresenceOfElement(username_field
				, wait);
		WebElement usernameEle = commons.findElement(username_field);
		commons.sendKeys(usernameEle, user);
		log.info("Entered username : " + user);
	}
	
	public void enterPassword(String password) throws FileIsNotPresent, IOException, ParseException
	{
		WebElement passwordEle = commons.findElement(pwd_field);
		commons.sendKeys(passwordEle, password);
		log.info("Entered password : " + password);
	}
	
	public void clickLoginButton() throws FileIsNotPresent, IOException, ParseException
	{
		WebElement loginButton = commons.findElement(login_button);
		loginButton.click();
		log.info("login button clicked");
	}
	
	public String verifyLoginError() throws FileIsNotPresent, IOException, ParseException
	{
		commons.waitForPresenceOfElement(login_error, wait);
		WebElement ele = commons.findElement(login_error);
		String message = ele.getText();
		log.info("Login Error Message : "+ message);
		return message;
	}
	
	
	
	
}
