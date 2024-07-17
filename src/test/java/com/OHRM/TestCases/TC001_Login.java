package com.OHRM.TestCases;

import org.testng.annotations.Test;

import com.OHRM.PageObjects.HomePage;
import com.OHRM.PageObjects.LoginPage;
import com.OHRM.PageObjects.PIMPage;

public class TC001_Login extends BaseClass
{
	@Test
	public void loginTest()
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUName(loginUid);
		logger.info("user name entered");
		lp.setPwd(loginPwd);
		logger.info("password entered");
		lp.clickLogin();
		logger.info("Home page Opened");
	}
	@Test
	public void pimTest()
	{
		HomePage hp=new HomePage(driver);
		hp.clickPim();
		logger.info("pim is clicked");
		
		PIMPage pp=new PIMPage(driver);
		pp.clickAddEmpl();
		pp.setFirstName();
		pp.setMiddileName();
		pp.setLastName();
		pp.clickCreateLoginDetails();
		pp.setUsername();
		pp.setPass();
		pp.setConfirmPass();
		pp.clickSave();
		logger.info("employee is created");
		teardown();
		logger.info("app closed");
	}
}
