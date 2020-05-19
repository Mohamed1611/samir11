package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase
{

	public CompareProductsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css="h1")
	public WebElement ComparePageHeader;
	
	@FindBy(css="a.clear-list")
	WebElement ClearList;

	@FindBy(tagName="tr")
	public List<WebElement> Rows;

	@FindBy(tagName="td")
	public List<WebElement> Colls;

	@FindBy(linkText="Asus N551JK-XO076H Laptop")
	public WebElement FirstProductName;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement SecondProductName;
	
	@FindBy(css="div.no-data")
	public WebElement ClearProductsMessage;
	
	public void ClearCompareList()
	{
		ClickButton(ClearList);
	}
	
	public void CompareProducts()
	{
		//Get all rows
		System.out.println(Rows.size());
		
		//get data from each row
		
		for (WebElement Row : Rows) 
		{
			System.out.println(Row.getText() + "\t");
			for (WebElement Coll : Colls) 
			{
				System.out.println(Coll.getText() + "\t");
				
			}
			
		}
		
	}

}
