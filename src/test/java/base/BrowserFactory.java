package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadConfigFile;

public class BrowserFactory 
{

	protected WebDriver driver;
	
	
	ReadConfigFile file = new ReadConfigFile();
	String browser = file.getBrowser();
 
	public WebDriver getDriver()
	{

		switch(browser)
		{
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/executables/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}

		return this.driver;
	}


}
