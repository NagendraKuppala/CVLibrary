package main.java.PageEvents;


import main.java.PageObjects.HomePageElements;
import main.java.util.ElementLocator;
import org.openqa.selenium.support.ui.Select;
import test.java.BaseTest;

public class HomePageEvents {

	public void findJobsInCVLibrary(String jobTitle, String jobLocation, String jobDistance){
		ElementLocator locator = new ElementLocator();

		BaseTest.logger.info("Enter Job Tile/Keyword");
		locator.getWebElement("XPATH", HomePageElements.jobTitle).sendKeys(jobTitle);

		BaseTest.logger.info("Enter Job Location");
		locator.getWebElement("XPATH", HomePageElements.location).sendKeys(jobLocation);

		BaseTest.logger.info("Select Job Distance");
		Select distance = new Select(locator.getWebElement("XPATH", HomePageElements.distance));
		distance.selectByValue(jobDistance);

		BaseTest.logger.info("Click in Find Jobs");
		locator.getWebElement("XPATH", HomePageElements.findJobsButton).click();
	}

}
