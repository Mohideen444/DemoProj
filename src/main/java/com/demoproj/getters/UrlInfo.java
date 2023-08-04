package com.demoproj.getters;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import com.demoproj.enums.ProjectStructure;
import com.demoproj.library.FileHandler;
import com.demoproj.library.JSONFileHandler;
import com.demoproj.setup.GlobalConfiguration;
import com.demoproj.setup.GlobalPaths;

public class UrlInfo {
	
	
	//Reading test data from the json files using jsonFileHandler library under com.demoproj.library package
	
	GlobalPaths globalPaths = new GlobalPaths();
	
	String hrm_url_path = ProjectStructure.pathToProject.toString()
			+globalPaths.getFile_separator()
			+ProjectStructure.testdata.toString()
			+globalPaths.getFile_separator()
			+globalPaths.getEnv()
			+globalPaths.getFile_separator()
			+"app-urls.json";

	
	public String getHrmUrls(String url_key) throws FileHandler.FileHandlerException.FileIsNotPresent, IOException, ParseException
	{
		return new JSONFileHandler(hrm_url_path)
				.parseObject("hrm")
				.parseObject(url_key).toString();
	}
	
	
	public static void main(String[] args) throws FileHandler.FileHandlerException.FileIsNotPresent, IOException, ParseException {
		GlobalConfiguration.init();
		UrlInfo u = new UrlInfo();
		String s = u.getHrmUrls("login").toString();
		System.out.println("The URL is :" + s);
	}

}