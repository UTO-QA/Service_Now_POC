package edu.service_now.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class change_request_list {
		private WebDriver driver;
		public change_request_list(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void focus(){
			driver.switchTo().parentFrame();
		}
		@FindBy(xpath="//select")
		private WebElement select;
		@FindBy(xpath="//input[@class='form-control ng-pristine ng-valid ng-touched']")
		private WebElement input_change;
		public void select_number_option(){
			Select sel=new Select(select);
			sel.selectByIndex(1);
		}
		public void input_change(String val){
			input_change.sendKeys(val);
		}
		public void search(){
			
		}
		
}
