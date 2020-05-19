package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	// Load the properties file from the folder
	public static Properties UserData =
	loadProperties(System.getProperty
			("user.dir")+"\\src\\main\\java\\properties\\UserData.properties");
	
	private static Properties loadProperties(String path)
	{
		
		Properties Pro = new Properties();
		
		//Stream for reading file
		try {
			FileInputStream Stream = new FileInputStream(path);
			Pro.load(Stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured" + e.getMessage());
		} catch (IOException e) {
			
			System.out.println("Error Occured" + e.getMessage());
		}
		catch(NullPointerException e)
		{
			System.out.println("Error Occured" + e.getMessage());
		}
		return Pro;
	}

}
