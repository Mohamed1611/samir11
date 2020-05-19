package data;

import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader 
{
	public String FirstName,LastName,Email,Password;
	
	public void JsonReader() throws FileNotFoundException, IOException, ParseException
	{
		String FilePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\JsonUserData.json";
		File SrcFile = new File(FilePath);
		
		JSONParser Parser = new JSONParser();
		JSONArray jArray = (JSONArray) Parser.parse(new FileReader(SrcFile));
		
		for(Object jsonObj : jArray)
		{
			JSONObject Person = (JSONObject) jsonObj;
			FirstName = (String) Person.get("FirstName");
			System.out.println(FirstName);
			
			LastName = (String) Person.get("LastName");
			System.out.println(LastName);
			
			Email = (String) Person.get("Email");
			System.out.println(Email);
			
			Password = (String) Person.get("Password");
			System.out.println(Password);
			
			System.out.println("\t");
		}
		
		
		
		
	}

}
