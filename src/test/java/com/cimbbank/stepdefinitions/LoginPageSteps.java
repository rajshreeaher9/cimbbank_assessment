package com.imdpeach.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.imdpeach.base.TestBase;
import com.imdpeach.pageobjects.LoginPage;
import com.imdpeach.pageobjects.SecureAreaPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author biswanath.padhi
 *
 */
public class LoginPageSteps extends TestBase{

	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;
	private Logger logger;

	public LoginPageSteps() {
		logger = LogManager.getLogger(LoginPageSteps.class);
		logger.info("Inside LoginPageSteps constructor");
		loginPage = new LoginPage(driver);
	}
	
	@Given("^user on login page$")
	public void user_on_login_page() {
		driver.get(properties.getProperty("loginUrl"));
	}

	@When("^user clicks on the Login button$")
	public void user_clicks_on_the_Login_button() {
		try {
			secureAreaPage = loginPage.clickLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("exception occured");
		}
	}

	@Then("^an error message stated \"([^\"]*)\" appear$")
	public void an_error_message_stated_appear(String expectedMessage) {
		try {
			Assert.assertEquals(loginPage.getLoginErrorMessageText(), expectedMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
	}

	@When("^user fill in username, password and clicks on Login button$")
	public void user_fill_in_username_password_and_clicks_on_Login_button(){
		try {
			loginPage.enterUsername(properties.getProperty("username"));
			loginPage.enterPassword(properties.getProperty("password"));
			secureAreaPage = loginPage.clickLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("exception occured");
		}
	}

	@Then("^a successful message stated \"([^\"]*)\" appear$")
	public void a_successful_message_stated_appear(String expectedMessage) {
		try {
			Assert.assertEquals(secureAreaPage.getLoginSuccessMessage(), expectedMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("exception occured");
		}
	}
}
