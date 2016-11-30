package edu.service_now.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Service_Now_HomePage {
	private WebDriver driver;
	public Service_Now_HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindAll({@FindBy(xpath="//a[@title='Create New' ]")})
List<WebElement>create_new_List;

private WebElement create_new(String scenario){
	scenario.toLowerCase();
	if(scenario.equals("incident"))
		return create_new_List.get(0);
	else if (scenario.equals("knowledge"))
		return create_new_List.get(1);
	else if (scenario.equals("change"))
		return create_new_List.get(2);
	else if(scenario.equals("problem"))
		return create_new_List.get(3);
	else 
		return null;
}
public void Create_new_scenario(String scenario){
	create_new(scenario).click();}

}
