package com.OHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OHRM.TestCases.BaseClass;
import com.OHRM.Utilities.ExcelFileReader;

public class PIMPage 
{
	WebDriver driver;
	public PIMPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Add Employee']")
	WebElement addEmployee;
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='middleName']")
	WebElement middleName;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	@FindBy(xpath="//div[@class='oxd-switch-wrapper']")
	WebElement createLoginDetails;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement userName;
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/descendant::input")
	WebElement password;
	@FindBy(xpath="(//div[@class='oxd-grid-item oxd-grid-item--gutters']/descendant::input[@class='oxd-input oxd-input--active'])[3]")
	WebElement confirmPass;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement save; 
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	WebElement cancel;
	
	String fName=ExcelFileReader.excelData("PIM", 1, 0);
	String mName=ExcelFileReader.excelData("PIM", 1, 1);
	String lName=ExcelFileReader.excelData("PIM", 1, 2);
	String eUsername=new BaseClass().randomString(7);
	String ePass=ExcelFileReader.excelData("PIM", 1, 4);
	public void clickAddEmpl()
	{
		addEmployee.click();
	}
	public void setFirstName()
	{
		firstName.sendKeys(fName);
	}
	public void setMiddileName()
	{
		middleName.sendKeys(mName);
	}
	public void setLastName()
	{
		lastName.sendKeys(lName);
	}
	public void clickCreateLoginDetails()
	{
		createLoginDetails.click();
	}
	public void setUsername()
	{
		userName.sendKeys(eUsername);
	}
	public void setPass()
	{
		password.sendKeys(ePass);
	}
	public void setConfirmPass()
	{
		confirmPass.sendKeys(ePass);
	}
	public void clickSave()
	{
		save.click();
	}
	public void clickCancel()
	{
		cancel.click();
	}
	
}
