package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase
{

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/h2/a")
	WebElement ProductLink;

	public void OpenProductLink()
	{
		ClickButton(ProductLink);
	}
	

}
