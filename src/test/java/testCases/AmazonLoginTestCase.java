package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class AmazonLoginTestCase extends BaseTest
{

	//@Test
	public void amazonLoginTest() throws Exception
	{

		driver.get("http://amazon.in");

		WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
		signInLink.click();

		driver.findElement(By.id("ap_email")).sendKeys("9966973477");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("amazon26");
		driver.findElement(By.id("signInSubmit")).click();

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class = 'nav-line-1-container']"))).build().perform();
		Thread.sleep(4000);
		WebElement signout = driver.findElement(By.id("nav-item-signout"));
		actions.moveToElement(signout).build().perform();
		signout.click();

	}
	
	@Test(dataProvider = "loginData")
	public void amazonLoginTestWithDp(String username, String password) throws InterruptedException
	{

		driver.get("http://amazon.in");

		WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
		signInLink.click();

		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class = 'nav-line-1-container']"))).build().perform();
		Thread.sleep(4000);
		WebElement signout = driver.findElement(By.id("nav-item-signout"));
		actions.moveToElement(signout).build().perform();
		signout.click();

		
	}
	@DataProvider(name = "loginData")
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "9966973477";
		data[0][1] = "amazon26";
		
		data[1][0] = "8106851390";
		data[1][1] = "sirisha";

		return data;
	}
}
