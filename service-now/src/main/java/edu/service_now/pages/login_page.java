package edu.service_now.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class login_page {
	
	@FindBy(id="user_name")
	private WebElement username;
	@FindBy(id="user_password")
	private WebElement password;
	@FindBy(id="sysverb_login")
	private WebElement login;
	private WebDriver driver;
	public login_page(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	public WebElement getLogin() {
		return login;
	}
	public void setUsername(String username) {
		this.username.sendKeys(username);
	}
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	public void login_wait(){
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	public void login(){
		login.click();
	}
	
}
	