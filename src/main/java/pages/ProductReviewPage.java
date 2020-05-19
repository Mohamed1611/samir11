package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase
{

	public ProductReviewPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="AddProductReview_Title")
	WebElement ReviewTitleTxtField;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement ReviewTextField;

	@FindBy(id="addproductrating_4")
	WebElement RatingRadioBtn;

	@FindBy(css="input.button-1.write-product-review-button")
	WebElement SubmitReviewBtn;

	public void UserCanSubmitAReview(String ReviewTitle, String ReviewText )
	{
		FillTextBox(ReviewTitleTxtField, ReviewTitle);
		FillTextBox(ReviewTextField, ReviewText);
		ClickButton(RatingRadioBtn);
		ClickButton(SubmitReviewBtn);
	}

}
