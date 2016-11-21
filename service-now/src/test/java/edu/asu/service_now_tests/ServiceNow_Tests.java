package edu.asu.service_now_tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.service_now.pages.login_page;
import edu.service_now.pages.service_now_commons;

public class ServiceNow_Tests {
	private WebDriver driver;
	private login_page login;
	@Given("tries to login")
	public void getconnection(){
		driver=service_now_commons.getconn();
		login=new login_page(driver);
	}
	//delete a connection
	public void closeconnection(){
		service_now_commons.closeconn();
	}
	
	@When("logs in")
	public void create_and_Submit(){
		login.setUsername("sparky_itil");
		login.setPassword("qapass123");
		login.login();
	}
	@Then("should login")
	public void assert_result(){
		Assert.assertEquals("/nav_to.do?uri=%2Fhome_splash.do%3Fsysparm_direct%3Dtrue",login.get_title());
	}
	

}
