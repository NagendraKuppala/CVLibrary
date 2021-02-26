package main.java.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

public class ElementLocator {

	/** Element locators based on locator type */
	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch (identifierType) {
			case "ID":
				return BaseTest.driver.findElement(By.id(identifierValue));
			case "CLASSNAME":
				return BaseTest.driver.findElement(By.className(identifierValue));
			case "XPATH":
				return BaseTest.driver.findElement(By.xpath(identifierValue));
			case "CSS":
				return BaseTest.driver.findElement(By.cssSelector(identifierValue));
			case "LINK":
				return BaseTest.driver.findElement(By.linkText(identifierValue));
			case "NAME":
				return BaseTest.driver.findElement(By.name(identifierValue));
			case "TAGNAME":
				return BaseTest.driver.findElement(By.tagName(identifierValue));
		}
		return null;
	}

}
