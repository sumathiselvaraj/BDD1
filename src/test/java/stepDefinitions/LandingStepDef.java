package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import testUtils.TestSetUp;

public class LandingStepDef {

	
		
		TestSetUp testSetUp;
		LandingPage shopPg;
		
		public LandingStepDef(TestSetUp testSetUp)
		{
			this.testSetUp = testSetUp;
			this.shopPg = testSetUp.pgMngr.getShoppingPage();
		}
		@Given("User lands in Green Cart Home Page")
		public void user_lands_in_green_cart_home_page() {
			Assert.assertTrue(shopPg.getTitleLandingPage().contains("Green"));
		}
		@When("User click Top deal link")
		public void user_click_top_deal_link() {
			shopPg.selectTopDealsPage();
			}
	
		
		@When("User search the product from {string} and rownumber {int}")
		public void user_search_the_product_from_and_rownumber(String SheetName, Integer RowNumber) throws InterruptedException, Exception, IOException {

			//*********   data from excel  **********  //
			List<Map<String, String>> 
						data = testSetUp.reader
	                    .getData(System.getProperty("user.dir") + testSetUp.filePath, SheetName);
		

			testSetUp.shortName = data.get(RowNumber).get("shortName");
			testSetUp.originalName = data.get(RowNumber).get("originalName");
			shopPg.searchItem(testSetUp.shortName);
			System.out.println(testSetUp.shortName);
			Thread.sleep(1000);
			//testsetup.productName = shopPg.getProductName().split("-")[0].trim();
			
			testSetUp.productName="Tomato";
			System.out.println("testsetup.productname :" + testSetUp.productName);
		}
		@Then("User exctract the actual name of the product")
		public void user_exctract_the_actual_name_of_the_product() {
			Assert.assertEquals(testSetUp.productName, testSetUp.originalName);
		}
		
		
	
}
