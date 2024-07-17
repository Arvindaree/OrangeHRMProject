package com.OHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage 
{
	WebDriver driver;
	public AdminPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement userName;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	WebElement userRole;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement employeeName;
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	WebElement status;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement search;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	WebElement reset;
	
	public void setuserName(String uName)
	{
		userName.sendKeys(uName);
	}
	public void selectuserRole(String uRole)
	{
		new Select(userRole).selectByVisibleText(uRole);
	}
	public void setemployeeName(String eName)
	{
		employeeName.sendKeys(eName);
	}
	public void selectstatus(String statusType)
	{
		new Select(status).selectByVisibleText(statusType);
	}
	public void clickSearch()
	{
		search.click();
	}
	public void clickReset()
	{
		reset.click();
	}
}
