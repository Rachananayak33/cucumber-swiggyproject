package com.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		features = "src\\test\\resources\\features",
		glue = {"com.stepdef"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/myreport.html"}
		
		)

public class TestRunnerSwiggy {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml"));
	}

}
