package edu.service_now.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_change_survey {
	private WebDriver driver;
	 public create_change_survey(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 @FindBy(xpath="//iframe[@class='gb_iframe']")
		private WebElement fill_out_assesment_frame;
	 @FindAll({@FindBy(xpath="//tr[contains(@id,'element.QUESTION')]")})
	 private List<WebElement> survey_questions;
	 @FindBy(id="post_survey")
	 private WebElement submit_survey;
	
	 private String survey_question="//input[contains(@id,'QUESTION')]";
	 public void focus(){
		 driver.switchTo().frame(fill_out_assesment_frame);
	 }
	 public void surveyquestions(){
		 for(WebElement elem:survey_questions){
			 String id=elem.getAttribute("id");
			 List<WebElement>input_radio=elem.findElements(By.xpath("//tr[@id='"+id+"']//label"));
			 input_radio.get(1).click();
			 JavascriptExecutor executor = (JavascriptExecutor) driver;
			 executor.executeScript("arguments[0].click();",input_radio.get(1));
		 }
	 }
	 public void submit_survey(){
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click();",submit_survey);
	 }
	 
}
