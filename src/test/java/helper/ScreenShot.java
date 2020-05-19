package helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot 
{
	//Method to take screenshot when Any Method failed

	public static void TakeScreenShot(WebDriver driver ,String ScreenShotName )
	{
		Path destination = Paths.get("./ScreenShots", ScreenShotName+".png");
		try 
		{
			Files.createDirectories(destination.getParent());
			FileOutputStream OutFile= new FileOutputStream(destination.toString());
			OutFile.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			OutFile.close();

		} catch (IOException e) 
		{
			System.out.println("Exception While taking screenshot"+ e.getMessage());
		}

	}

}
