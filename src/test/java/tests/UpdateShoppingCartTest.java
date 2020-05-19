package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductSelectionPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class UpdateShoppingCartTest extends TestBase
{
	HomePage HomePageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject; 
	ShoppingCartPage ShoppingCartPageObject;
	
	
	@Test(priority=0)
	public void TestUserCanUpdateInProductQuantityAndClearProductInShoppingCart() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
        HomePageObject.UserCanSearch("Apple MacBook Pro 13-inch");
        Thread.sleep(1000);
        SearchPageObject = new SearchPage(driver);
        SearchPageObject.OpenProductLink();
        Thread.sleep(1000);
        ProductSelectionPageObject = new ProductSelectionPage(driver);
        ProductSelectionPageObject.ClickOnAddToCartBtn();
        Thread.sleep(1000);
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        Thread.sleep(2000);
        
        //Change Product Quantity
        ShoppingCartPageObject = new ShoppingCartPage(driver);
        ShoppingCartPageObject.UserCanAddQuantityOfProductInShoppingCart("4");
        Thread.sleep(3000);
        //Assert.assertTrue(ShoppingCartPageObject.TotalAmount.getText().contains("7,200"));
       
        
        // Delete Products in shopping cart
		 ShoppingCartPageObject.UserCanDeleteProductInShoppingCart();
		 Thread.sleep(2000);
		 //Assert.assertEquals(ShoppingCartPageObject.RemoveShoppingCartMessage.getText(), "Your Shopping Cart is empty!");
		// Thread.sleep(2000);
		 driver.navigate().to("https://demo.nopcommerce.com/");
			Thread.sleep(2000);
        
	}
	


}
