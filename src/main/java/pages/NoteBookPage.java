package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoteBookPage extends PageBase
{

	public NoteBookPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="h1")
	public WebElement Header;

}
