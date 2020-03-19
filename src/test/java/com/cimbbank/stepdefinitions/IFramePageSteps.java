package com.imdpeach.stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.imdpeach.base.TestBase;
import com.imdpeach.pageobjects.IFramePage;
import com.imdpeach.pageobjects.LoginPage;
import com.imdpeach.util.TestUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author biswanath.padhi
 *
 */
public class IFramePageSteps extends TestBase{
	
	private Logger logger;
	private IFramePage iFramePage;
	
	public IFramePageSteps() {
		logger = LogManager.getLogger(IFramePageSteps.class);
		logger.info("Inside IframePageSteps constructor");
		iFramePage = new IFramePage(driver);
	}
	
	@Given("^user on iframe page$")
	public void user_on_iframe_page() throws Exception {
		driver.get(properties.getProperty("iFrameUrl"));
	}

	@When("^user type \"([^\"]*)\" in the text box$")
	public void user_type_in_the_text_box(String message) throws Exception {
		util.switchToFrameByNameOrId("mce_0_ifr");
		iFramePage.clearTextEditor();
		iFramePage.enterTextInTextEditor(message);
	}

	@Then("^textbox shows \"([^\"]*)\"$")
	public void textbox_shows(String expected) throws Exception {
		String actual = iFramePage.getTextFromTextEditor();
		assertEquals(actual, expected);
	}
}
