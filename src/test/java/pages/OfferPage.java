package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testUtils.testBase;

public class OfferPage extends testBase{
	
	public WebDriver driver;

	public OfferPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	
	@FindBy(id = "search-field")   WebElement search;
	@FindBy(css  = "tr td:nth-child(1)")  WebElement productName;
	@FindBy(xpath = "//*[contains(text(),'Top Deals')]")   WebElement topDeals;
	@FindBy(css = "a.increment") WebElement increment;
	@FindBy(css = ".product-action button")   WebElement addToCart;

	// 5-6

	public void searchItem(String name) {
		search.sendKeys(name);
	}

	public void getSearchText() {
		search.getText();
	}

	
	public String getProductName() {
		return productName.getText();
	}

	
	public String getTitleOfferPage()
	{
		return driver.getTitle();
	}

	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}

}
