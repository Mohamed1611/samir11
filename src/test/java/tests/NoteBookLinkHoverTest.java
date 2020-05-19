package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.NoteBookPage;

public class NoteBookLinkHoverTest extends TestBase
{
	HomePage HomePageObject;
	NoteBookPage NoteBookPageObject;
	
	@Test
	public void TestNoteBookLinkHover() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenNoteBooksLink();
		Thread.sleep(3000);
		NoteBookPageObject = new NoteBookPage(driver);
        Assert.assertEquals(NoteBookPageObject.Header.getText(), "Notebooks");
        Thread.sleep(3000);
		
	}

}
