package edu.service_now.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.ActionChainExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Change_page {
	private WebDriverWait wait;
	private WebDriver driver;
	public Create_Change_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@id='53aeb78ec0a8020f00c2b2af653daa7d']")
	private WebElement FillOut;
	@FindBy(id="sys_readonly.change_request.number")
	private WebElement Number;
	public String getNumber() {
		return Number.getAttribute("value").toString();
	}
	@FindBy(xpath="//div[@id='tabs2_section']/span[2]/span/span[2]")
	private WebElement schedule_tab;
	@FindBy(id="sys_readonly.change_request.number")
	private WebElement ChnageReq_Number;
	@FindBy(id="sys_display.change_request.assignment_group")
	private WebElement assignment_group;
	@FindBy(id="change_request.category")
	private WebElement category;
	@FindBy(id="change_request.short_description")
	private WebElement short_description;
	@FindBy(id="change_request.start_date")
	private WebElement start_date;
	@FindBy(id="change_request.end_date")
	private WebElement end_date;
	@FindBy(xpath="//button[contains(.,'Submit')]")
	private WebElement submit;
	@FindBy(xpath="//iframe[@name='gsft_main']")
	private WebElement frame;
	@FindBy(id="view.change_request.assignment_group")
	private WebElement view_assignment_group;
	@FindBy(id="sysverb_insert_and_stay")
	private WebElement save_button;
	 @FindBy(id="928001540a0a2c764eaf70d16624a94a")
	 private WebElement Execute_risk;
	 @FindBy(id="sysverb_update")
	 private WebElement update;
	public void select_category(String visible){
			Select cat=new Select(category);
			cat.selectByVisibleText(visible);;
	}
	public void wait_fucntion(int time,WebElement elem){
		wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(elem));

	}
	public boolean Assign_Group(String value){
		assignment_group.sendKeys(value+Keys.ENTER);
		return view_assignment_group.isDisplayed();
	}
	public void enter_description(){
		short_description.sendKeys("this is a short description");
	}
	public void focus(){
		driver.switchTo().parentFrame();
		driver.switchTo().frame(frame);
	}
	public void filldates(String start,String end){
		schedule_tab.click();
		start_date.sendKeys(start);
		end_date.sendKeys(end);
	}
	public void save_scenario(){
		save_button.click();
	}
	public void Fillout(){
		FillOut.click();
	}
	public void Execute_risk(){
		Execute_risk.click();
	}
	public void update_button(){
		update.click();
	}
	
}
