package com.imdpeach.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.imdpeach.base.TestBase;
import com.imdpeach.pageobjects.JavaScriptAlertPage;
import com.imdpeach.pageobjects.LoginPage;
import com.imdpeach.util.TestUtil;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author biswanath.padhi
 *
 */
public class JavaScriptAlertPageSteps extends TestBase{
	
	private Logger logger;
	private JavaScriptAlertPage javaScriptAlertPage;
	
	public JavaScriptAlertPageSteps() {
		logger = LogManager.getLogger(JavaScriptAlertPageSteps.class);
		logger.info("Inside JavaScriptAlertPageSteps constructor");
		javaScriptAlertPage = new JavaScriptAlertPage(driver);
	}
	
	@Given("^user on alert page$")
	public void user_on_alert_page() throws Exception {
	   
		try {
			driver.get(properties.getProperty("alertUrl"));
		} catch (Exception e) {
			logger.debug("Failed to navigate to alert page");
			logger.error("Exception occured: " + e.getMessage());
		}
	}

	@When("^user clicks on JS button \"([^\"]*)\"$")
	public void user_clicks_on_JS_button(String buttonToClick) {
		
		try {
			if(buttonToClick.toLowerCase().contains("confirm")) {
				javaScriptAlertPage.clickOnJSConfirm();
				util.accept();
			} else if (buttonToClick.toLowerCase().contains("prompt")) {
				javaScriptAlertPage.clickOnJSPrompt();
			}
		} catch (Exception e) {
			logger.debug("Failed to click on JS Button: " + buttonToClick);
			logger.error("Exception occured: " + e.getMessage());
		}
	}

	@When("^user enters the text \"([^\"]*)\" and selects \"([^\"]*)\"$")
	public void user_enters_the_text_and_selects(String textToEnter, String choice) throws Throwable {
		
		try {
			enterTextBasedOnJSAlert(textToEnter);
			performChoiceAction(choice);
		} catch (Exception e) {
			logger.debug("Failed to enter text or select alert");
			logger.error("Exception occured: " + e.getMessage());
		}
	}
	
	@Then("^result showing \"([^\"]*)\"$")
	public void result_showing(String expectedMessage){
		
		try {
			assertEquals(javaScriptAlertPage.getResultMessage(), expectedMessage);
		} catch (Exception e) {
			logger.debug("Failed to verify displayed result message");
			logger.error("Exception occured: " + e.getMessage());
		}
	}
	

	private void performChoiceAction(String choice) {

		try {

			if (choice.trim().equalsIgnoreCase("ok"))
				util.accept();
			else if (choice.trim().equalsIgnoreCase("cancel"))
				util.dismiss();
			else
				logger.error("Invalid choice selected: " + choice);
		} catch (Exception e) {
			logger.debug("Failed to execute performChoiceAction");
			logger.error("Exception occured: " + e.getMessage());
		}
	}

	private void enterTextBasedOnJSAlert(String textToEnter) {
		try {

			// Cases textToEnter is having value - for Prompt alert
			if(!(textToEnter.equalsIgnoreCase("na") || textToEnter.isEmpty())) {
				util.sendKeysToAlert(textToEnter);
				util.dismiss();
			}
		} catch (Exception e) {
			logger.debug("Failed to enterTextBasedOnJSAlert: " + textToEnter);
			logger.error("Exception occured" + e.getMessage());
		}
	}
}
