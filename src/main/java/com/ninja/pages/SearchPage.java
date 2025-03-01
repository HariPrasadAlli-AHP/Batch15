package com.ninja.pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(name = "search")
	WebElement searchTextField;

	@FindBy(xpath = "//*[@class='btn btn-default btn-lg']")
	WebElement SearchButton;

	@FindBy(xpath = "//*[text()='There is no product that matches the search criteria.']")
	WebElement Messagealertdisplay;

	public SearchPage(WebDriver driver) throws Exception {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void searchProductEnterName() {
		wait.until(ExpectedConditions.visibilityOf(searchTextField));
		wait.until(ExpectedConditions.elementToBeClickable(searchTextField)).sendKeys("abc");
		wait.until(ExpectedConditions.visibilityOf(SearchButton));
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
	}

	public boolean isMessagedisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			return wait.until(ExpectedConditions.visibilityOf(Messagealertdisplay)).isDisplayed();
		} catch (TimeoutException e) {
			return false; // Return false if the popup is not found within 10 seconds
		}
	}

}
