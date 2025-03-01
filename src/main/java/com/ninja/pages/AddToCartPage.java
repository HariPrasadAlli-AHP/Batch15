package com.ninja.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[text()='Desktops']")
	WebElement DesktopMenu;

	@FindBy(xpath = "//a[text()='Desktops']/following::a[contains(text(),'Mac ')]")
	WebElement MacMenu;

	@FindBy(xpath = "//*[text()='iMac']")
	WebElement iMacProduct;

	@FindBy(id = "input-quantity")
	WebElement qtyofCurrentProduct;

	@FindBy(xpath = "//*[@id='button-cart']")
	WebElement AddtoCartbutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessMessagePopUp;
	
	@FindBy(xpath = "//*[text()='Shopping Cart']")
	WebElement ShoppingCartbutton;
	
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=checkout/checkout' and @class='btn btn-primary']")
	WebElement CheckOutbutton;

	public AddToCartPage(WebDriver driver) throws Exception {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void navigateToMac() {
        wait.until(ExpectedConditions.elementToBeClickable(DesktopMenu)).click();

        wait.until(ExpectedConditions.elementToBeClickable(MacMenu)).click();
	}

	public void AddtoCartiMac() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(iMacProduct));
		wait.until(ExpectedConditions.elementToBeClickable(iMacProduct)).click();
		wait.until(ExpectedConditions.visibilityOf(qtyofCurrentProduct));
		wait.until(ExpectedConditions.elementToBeClickable(qtyofCurrentProduct)).sendKeys("10");
		wait.until(ExpectedConditions.visibilityOf(AddtoCartbutton));
		wait.until(ExpectedConditions.elementToBeClickable(AddtoCartbutton)).click();
		Thread.sleep(2000);

	}
	
	public void checkOutwithOneProduct() {
		wait.until(ExpectedConditions.visibilityOf(ShoppingCartbutton));
		wait.until(ExpectedConditions.elementToBeClickable(ShoppingCartbutton)).click();
		wait.until(ExpectedConditions.visibilityOf(CheckOutbutton));
		wait.until(ExpectedConditions.elementToBeClickable(CheckOutbutton)).click();
	}

	public String getDesktopsFirstMacText() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(iMacProduct));
			return element.getText().replace("×", "").trim(); 
		} catch (TimeoutException e) {
			return ""; // Return empty string if the element is not found
		}
	}

	public String SuccessPopUpAfterAddToCart() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(SuccessMessagePopUp));
			return element.getText().replace("×", "").trim();  // Extract and return the text
		} catch (TimeoutException e) {
			return ""; // Return empty string if the element is not found
		}
	}
}
