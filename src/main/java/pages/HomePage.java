package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);
		JSE = (JavascriptExecutor) driver;
		Action = new Actions(driver);

	}

	@FindBy(linkText="Register")
	WebElement RegisterLink;

	public void OpenRegisterLink()
	{
		ClickButton(RegisterLink);
	}

	@FindBy(linkText="Log in")
	WebElement LoginLink;

	public void OpenLoginLink()
	{
		ClickButton(LoginLink);
	}

	@FindBy(id="small-searchterms")
	WebElement SearchTxtBox;

	@FindBy(css="input.button-1.search-box-button")
	WebElement SearchBtn;

	public void UserCanSearch(String ProductName)
	{
		FillTextBox(SearchTxtBox, ProductName);
		ClickButton(SearchBtn);
	}
	// do it list bec i will search with list
	@FindBy(id="ui-id-1")
	List<WebElement> ProductList;

	public void UserCanSearchWithList(String PartOfProductName) throws InterruptedException
	{
		FillTextBox(SearchTxtBox, PartOfProductName);
		Thread.sleep(2000);
		ProductList.get(0).click();
	}

	@FindBy(linkText="Contact us")
	WebElement ContactUsLink;

	public void OpenContactUsLink() 
	{
		
		ClickButton(ContactUsLink);
	}
	
	@FindBy(id="customerCurrency")
	WebElement CurrencyList;
	
	public void ChangeCurrency()
	{
	
		Select = new org.openqa.selenium.support.ui.Select(CurrencyList);
		Select.selectByIndex(1);
	}

    @FindBy(linkText="Computers")
    WebElement ComputerLink;
    @FindBy(linkText="Notebooks")
    WebElement NoteBooksLink;
    
    public void OpenNoteBooksLink()
    {
      	Action
      	.moveToElement(ComputerLink)
      	.moveToElement(NoteBooksLink)
      	.click()
      	.build()
      	.perform();
    }



}
