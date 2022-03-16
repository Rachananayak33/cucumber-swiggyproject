package com.stepdef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef_Swiggy {
	
	WebDriver driver;
	String CHROME_DRIVER_EXE = "chromedriver99.0.exe";
	
	@Given("^user is on home page of www\\.swiggy\\.com$")
	public void user_is_on_home_page_of_www_swiggy_com() {
		System.out.println("Inside the @Given code");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\" + CHROME_DRIVER_EXE);
		driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
	   
	}

	
	  @When("^user enters mobile_number and otp$") public void
	  user_enters_mobile_number_and_otp(DataTable table) throws InterruptedException { 
		  System.out.println("Inside @When user enters the mobile_number and otp");
			List<Map<String, String>> dataMap = table.asMaps(String.class, String.class);
			for (Map<String, String> map : dataMap) {
				driver.findElement(By.xpath("//a[@class='x4bK8']")).click();
				driver.findElement(By.name("mobile")).clear();
				driver.findElement(By.name("mobile")).sendKeys(map.get("mobile_number"));
				driver.findElement(By.xpath("//a[@class='a-ayg']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='otp']")).clear();
				driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(map.get("otp"));
				
				
				
			}
	  
	  }
	  
	  @Then("^user should be logged in$") public void user_should_be_logged_in() throws InterruptedException{
		  System.out.println("Inside @Then verify otp");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//a[@class='a-ayg']")).click();
		  driver.quit();
		  
		 
	  } 
		  
	 }
	 




