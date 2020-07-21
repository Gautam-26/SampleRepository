package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile 
{

	protected InputStream input = null;
	protected Properties prop = null;

	public ReadConfigFile()
	{
		try {
			input = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
		    } 
		catch (IOException e) 
		{

			e.printStackTrace();
		}

	}

	public String getBrowser()
	{
		if(prop.getProperty("browser") == null)
			return "chrome";
		return prop.getProperty("browser");
	}
	
	public String getLoginUrl()
	{
		return prop.getProperty("loginUrl");
	}

}
