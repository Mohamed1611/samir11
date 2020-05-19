package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductSelectionPage;
import pages.RegisterationPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCanCheckOutProductTest extends TestBase
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;
	ShoppingCartPage ShoppingCartPageObject;
	CheckOutPage CheckOutPageObject; 
	
	String Email = "Moha123beko4@Test.com";
	String ProductName ="Apple MacBook Pro 13-inch";
	
	@Test(priority=0)
	public void TestGuestCanCheckOutProduct() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(3000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		// Add to shopping cart
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddToCartBtn();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(2000);
		
		//Checkout part
		ShoppingCartPageObject = new ShoppingCartPage(driver);
		ShoppingCartPageObject.UserCanCheckOutProducts();
		Thread.sleep(2000);
		
		//Guest Can check out products
		CheckOutPageObject = new CheckOutPage(driver);
		CheckOutPageObject.OpenCheckOutAsGuest();
		Thread.sleep(2000);
		CheckOutPageObject.GuestCanCheckOutProduct
		("MOha", "sasa", Email, "Cairo", "Faisl", "9292", "011141416001");
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderShippmentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderPaymentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutpaymentInformation();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutConfirmationOrder();
		Thread.sleep(1000);
		Assert.assertTrue(CheckOutPageObject.CheckOutOrderSuccessfullMessage.getText().contains
				("Your order has been successfully processed!"));

	}
	
	/*@Test(priority=1)
	public void AddToShopingCart() throws InterruptedException
	{
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnAddToCartBtn();
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void TestCheckOut() throws InterruptedException
	{
		ShoppingCartPageObject = new ShoppingCartPage(driver);
		ShoppingCartPageObject.UserCanCheckOutProducts();
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void TestGuestCanCheckOutProduct() throws InterruptedException
	{
		CheckOutPageObject = new CheckOutPage(driver);
		CheckOutPageObject.OpenCheckOutAsGuest();
		Thread.sleep(2000);
		CheckOutPageObject.GuestCanCheckOutProduct
		("MOha", "sasa", Email, "Cairo", "Faisl", "9292", "011141416001");
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderShippmentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutOrderPaymentMethod();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutpaymentInformation();
		Thread.sleep(1000);
		CheckOutPageObject.CheckOutConfirmationOrder();
		Thread.sleep(1000);
		Assert.assertTrue(CheckOutPageObject.CheckOutOrderSuccessfullMessage.getText().contains
				("Your order has been successfully processed!"));
	}*/
}
