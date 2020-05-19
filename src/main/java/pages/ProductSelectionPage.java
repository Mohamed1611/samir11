package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSelectionPage extends PageBase
{
	public ProductSelectionPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css="h1")
	public WebElement ProductHeader;


	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement EmailAFriendBtn;

	public void ClickOnEmailAFriend()
	{
		ClickButton(EmailAFriendBtn);
	}

	@FindBy(css="span.price-value-4")
	public WebElement ProductPriceTag;

	@FindBy(linkText="Add your review")
	WebElement AddYourReviewLink;

	public void ClickOnAddYourReviewLink()
	{
		ClickButton(AddYourReviewLink);
	}

	@FindBy(css="input.button-2.add-to-wishlist-button")
	WebElement AddToWishListBtn;

	public void ClickOnAddToWishBtn()
	{
		ClickButton(AddToWishListBtn);
	}

	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement AddToCompareListBtn;
	
	public void ClickOnAddToCompareListBtn()
	{
		ClickButton(AddToCompareListBtn);
	}
	
	@FindBy(id="add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	public void ClickOnAddToCartBtn()
	{
		ClickButton(AddToCartBtn);
	}



}
