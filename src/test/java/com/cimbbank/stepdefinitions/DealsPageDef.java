package com.cimbbank.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cimbbank.base.TestBase;
import com.cimbbank.pageobjects.DealsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DealsPageDef extends TestBase{
	
	private Logger logger;
	private DealsPage dealPage;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public DealsPageDef() {
		logger = LogManager.getLogger(DealsPageDef.class);
		logger.info("Inside DealPage constructor");
		dealPage = new DealsPage(driver);
	}
	
	@Given("^I am on CIMB page$")
	public void I_am_on_CIMB_page() throws Exception {
		driver.get(properties.getProperty("cimbUrl"));
	}

	@When("^I select CIMB Deals$")
	public void I_select_CIMB_Deals() throws Exception {
		
		dealPage.getdropDown().click();
		dealPage.getdeals().click();
		
		}
	@And("^I would like to explore more for \"([^\"]*)\" under Travel & Fun$")
	public void I_would_like_to_explore_more(String message) throws Exception {
		Thread.sleep(5000);
		
		dealPage.gettravelFun().click();
		Thread.sleep(5000);
		dealPage.getsearchTravelFun().click();
		dealPage.enterTextInTextEditor(message);
		dealPage.searchclick();
		
		dealPage.getdorsettSubang().click();
		Thread.sleep(5000);
		
	}

	@Then("^I will be able to see its details and other similar deals$")
	public void I_will_be_able_to_see_its_details() throws Exception {
		
		
			    
			
		Assert.assertEquals(dealPage.getDorsettText1(),"20% OFF Best Available Room Rates");	
		jse.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
		 Assert.assertEquals(true, dealPage.getoneDeal().isDisplayed());
		 Assert.assertEquals(true, dealPage.gettwoDeal().isDisplayed());
		 Assert.assertEquals(true, dealPage.getthreeDeal().isDisplayed());
		 Assert.assertEquals(true, dealPage.getfourDeal().isDisplayed());	
		
		}
	}
	

