package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewResultPage extends PageBase
{

	public ProductReviewResultPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="div.result")
	public WebElement AddReviewSuccessfullmMessage;

}
