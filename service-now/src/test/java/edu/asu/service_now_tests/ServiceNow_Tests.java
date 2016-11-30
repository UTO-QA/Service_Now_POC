package edu.asu.service_now_tests;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.service_now.pages.Create_Change_page;
import edu.service_now.pages.Service_Now_HomePage;
import edu.service_now.pages.change_request_list;
import edu.service_now.pages.create_change_survey;
import edu.service_now.pages.login_page;
import edu.service_now.pages.service_now_commons;

public class ServiceNow_Tests {
	private WebDriver driver;
	private String Number;
	private login_page login;
	private Service_Now_HomePage homepage;
	private Create_Change_page change;
	private create_change_survey survey;
	private change_request_list cr_list;
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
		login.login_wait();
		homepage=new Service_Now_HomePage(driver);
		homepage.Create_new_scenario("change");
		change=new Create_Change_page(driver);

		change.focus();
		Number=change.getNumber();
		change.select_category("Software");
		change.Assign_Group("Analytics");
		change.enter_description();
		change.filldates(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime()),"2017-11-23 12:14:17");
		change.save_scenario();
		change.Fillout();
		survey=new create_change_survey(driver);
		survey.focus();
		survey.surveyquestions();
		survey.submit_survey();
		change.focus();
		change.Execute_risk();
		change.select_category("Hardware");
		change.Assign_Group("Project Management");
		change.update_button();
		cr_list=new change_request_list(driver);
		//cr_list.focus();
		cr_list.select_number_option();
		cr_list.input_change(Number);
		cr_list.search();
	}
	@Then("should login")
	public void assert_result(){
		
	}
	

}
