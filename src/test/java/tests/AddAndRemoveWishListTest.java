package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSelectionPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddAndRemoveWishListTest extends TestBase
{
	HomePage HomePageObject;
	SearchPage SearchpageObject;
	ProductSelectionPage ProductSelectionPageObject;
	WishListPage WishListPageObject;
	
	String ProductName = "Apple MacBook Pro 13-inch";
	
	@Test(priority=0)
	public void TestAddAndRemoveProductFromWishList() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(2000);
		SearchpageObject = new SearchPage(driver);
		SearchpageObject.OpenProductLink();
		Thread.sleep(2000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddToWishBtn();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		Thread.sleep(2000);
		WishListPageObject = new WishListPage(driver);
		Assert.assertEquals(WishListPageObject.ProductsName.getText(), ProductName);
		Thread.sleep(2000);
		WishListPageObject.RemoveproductFromWishList();
		Assert.assertEquals(WishListPageObject.RemoveWishListMessage.getText(), "The wishlist is empty!");
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}

}
