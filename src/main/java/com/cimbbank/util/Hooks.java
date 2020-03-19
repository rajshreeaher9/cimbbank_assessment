package com.cimbbank.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cimbbank.base.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.runtime.ScenarioImpl; 
import gherkin.formatter.model.Result;  
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.lang.reflect.Field;  
import java.util.ArrayList;



public class Hooks extends TestBase {
	
	private static Logger logger= LogManager.getLogger(Hooks.class);

	@Before
    public void setUp(){
		logger.debug("****************************   BEFORE   **********************************");
        initializeDriver();
        util = new TestUtil(driver);
    } 
 
	@After
    public void tearDown(Scenario scenario){
		try {
			logger.debug("****************************   TEARDOWN   **********************************");
			if (scenario.isFailed())
				util.takeScreenshotAtEndOfTest();
			    logError(scenario);
			if(driver != null)
				driver.quit();
		} catch (IOException e) {
			logger.error("Exception in tearDown()");
		}
	}

	private static void logError(Scenario scenario) {
		Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
		field.setAccessible(true);
		try {
			ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
			for (Result result : results) {
				if (result.getError() != null)
					logger.error("Error Scenario: {}", scenario.getId(), result.getError());
			}
		} catch (Exception e) {
			logger.error("Error while logging error", e);
		}
	}
}
