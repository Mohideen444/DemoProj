package com.demoproj.runner;



import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demoproj.setup.BaseSetup;

import java.io.IOException;


//Runner file to execute the cucumber tests

@CucumberOptions(plugin = {
        "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},

        features = {"src/test/resources/features"},
        glue = {"com.demoproj.stepdefinition"},
        
        tags = "@loginError",
        
        monochrome = true,
        dryRun = false
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void startup() {
        try {
            BaseSetup.init();
            BaseSetup.getInstance().getScreenRecorder().startScreenRecording();
        } catch (Exception e) {
            System.out.println("At Start up Exception" + e.getMessage());
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDown() throws IOException, ParseException, InterruptedException {

        BaseSetup.getInstance().getScreenRecorder().stopScreenRecording();


        }
}
