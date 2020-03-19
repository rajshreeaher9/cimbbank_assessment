package com.cimbbank.util;

/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not need to call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.cimbbank.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

    private Logger logger;

    public WebEventListener() {
		// TODO Auto-generated constructor stub
    	logger = LogManager.getLogger(WebEventListener.class);
	}
    
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Before navigating to: '" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		logger.info("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		logger.info("Element value changed to: " + element.toString());
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Trying to click on: " + element.toString());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicked on: " + element.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		logger.info("Navigating back to previous page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		logger.info("Navigated back to previous page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		logger.info("Navigating forward to next page");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		logger.info("Navigated forward to next page");
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		logger.info("Exception occured: " + error);
		try {
			new TestUtil(driver).takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			logger.error("Exception occured: " + e.getMessage());
		} finally {
			if(driver != null)
				driver.quit();
		}
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Trying to find Element By : " + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	@Override
	public void beforeScript(String script, WebDriver driver) {
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
