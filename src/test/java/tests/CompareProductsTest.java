package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductSelectionPage;
import pages.SearchPage;

public class CompareProductsTest extends TestBase
{
	HomePage HomePageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;
	CompareProductsPage CompareProductsPageObject;
	
	@Test(priority=0)
	public void TestCompareProductsAndClearCompareList() throws InterruptedException
	{
		
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearch("Apple MacBook Pro 13-inch");
		Thread.sleep(1000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(2000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddToCompareListBtn();
		Thread.sleep(3000);
		
		//driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		//Thread.sleep(2000);
		
		HomePageObject.UserCanSearch("Asus N551JK-XO076H Laptop");
		Thread.sleep(2000);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		ProductSelectionPageObject.ClickOnAddToCompareListBtn();
		Thread.sleep(3000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Thread.sleep(2000);
		CompareProductsPageObject = new CompareProductsPage(driver);
		Assert.assertEquals(CompareProductsPageObject.ComparePageHeader.getText(), "Compare products");
		CompareProductsPageObject.CompareProducts();
		Thread.sleep(2000);
		
		//clear compare List
		CompareProductsPageObject = new CompareProductsPage(driver);
    	CompareProductsPageObject.ClearCompareList();
    	Thread.sleep(3000);
    	Assert.assertEquals(CompareProductsPageObject.ClearProductsMessage.getText(), "You have no items to compare.");
    	
		
	}
	
   /* @Test (priority=1)
    public void ClearCompareList() throws InterruptedException
    {
    	CompareProductsPageObject = new CompareProductsPage(driver);
    	CompareProductsPageObject.ClearCompareList();
    	Thread.sleep(3000);
    	Assert.assertEquals(CompareProductsPageObject.ClearProductsMessage.getText(), "You have no items to compare.");
    	
    }*/
}
