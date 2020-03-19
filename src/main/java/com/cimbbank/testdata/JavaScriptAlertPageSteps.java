package com.imdpeach.testdata;

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
	    driver.get(properties.getProperty("alertUrl"));
	    javaScriptAlertPage = new JavaScriptAlertPage(driver);
	}

	@When("^user clicks on “Click for JS Confirm” button and select \\[OK\\]$")
	public void user_clicks_on_Click_for_JS_Confirm_button_and_select_OK() throws Exception {
		javaScriptAlertPage.clickOnJSConfirm();
		util.accept();
	}

	@Then("^result showing JS Confirm message \"([^\"]*)\"$")
	public void result_showing_JS_Confirm_message(String expectedMessage) throws Exception {
		assertEquals(javaScriptAlertPage.getResultMessage(), expectedMessage);
	}

	@When("^user clicks on “Click for JS Prompt” button$")
	public void user_clicks_on_Click_for_JS_Prompt_button() throws Exception {
	    javaScriptAlertPage.clickOnJSPrompt();
	}

	@When("^user enters the test \"(.*)\" and clicks \\[Cancel\\]$")
	public void user_enters_the_test_Test_JS_Prompt_and_clicks_Cancel(String message) throws Exception {
		util.sendKeysToAlert(message);
		util.dismiss();
	}

	@Then("^result showing JS Prompt message \"([^\"]*)\"$")
	public void result_showing_JS_Prompt_message(String expectedMessage) throws Exception {
		assertEquals(javaScriptAlertPage.getResultMessage(), expectedMessage);
	}
}
