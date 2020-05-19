package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase
{

	public WishListPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css="h1")
	public WebElement Header;

	@FindBy(css="td.product")
	public WebElement ProductsName;

	@FindBy(name="removefromcart")
	WebElement RemoveCheckBox;

	@FindBy(css="input.button-2.update-wishlist-button")
	WebElement UpdateWishListBtn;

	@FindBy(css="div.no-data")
	public WebElement RemoveWishListMessage;

	public void RemoveproductFromWishList()
	{
		ClickButton(RemoveCheckBox);
		ClickButton(UpdateWishListBtn);
	}

}
