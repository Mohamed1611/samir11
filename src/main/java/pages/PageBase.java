package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase 
{
	// this driver will deal with elements in test case
	protected WebDriver driver;
	JavascriptExecutor JSE;
	public Select Select;
	public Actions Action;

	// create Constructor -- constructor same name of class without void public only
	public PageBase(WebDriver driver )
	{
		// this is keyword in java mean u r reading from this class the elements 
		PageFactory.initElements(driver, this);

	}

	protected static void ClickButton(WebElement Button)
	{
		Button.click();
	}

	protected static void FillTextBox(WebElement TextBoxWebelement , String Value)
	{
		TextBoxWebelement.sendKeys(Value);
	}

	public void Scroll()
	{
		JSE.executeScript("scrollBy(0,2500)");
	}

	public void ClearFiled(WebElement webElement)
	{
		webElement.clear();
	}

}
