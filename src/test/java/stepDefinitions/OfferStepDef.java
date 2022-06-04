package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OfferPage;
import testUtils.TestSetUp;

public class OfferStepDef {


		
		TestSetUp testSetUp;
		OfferPage offerPage;
		
		public OfferStepDef(TestSetUp testSetUp)
		{
			this.testSetUp = testSetUp;
			this.offerPage = testSetUp.pgMngr.getOfferPage();
		}
				
		@When("User search the product with {string} and {int} in deals")
		public void user_search_the_product_with_in_deals(String SheetName, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException {
			testSetUp.gUtil.windowHandle();
			offerPage.searchItem(testSetUp.shortName);;
			System.out.print(testSetUp.shortName); 
			Thread.sleep(1000);
			testSetUp.dealProduct = offerPage.getProductName().split("-")[0].trim();
		}
		@Then("User check if the product matches with landingpage")
		public void user_check_if_the_product_exists() {

	        System.out.println("step 1 :" + testSetUp.dealProduct);
	        System.out.println("step 2 :" + testSetUp.productName);
	      
		   Assert.assertEquals(testSetUp.dealProduct, testSetUp.productName);
			
		}
	
}
