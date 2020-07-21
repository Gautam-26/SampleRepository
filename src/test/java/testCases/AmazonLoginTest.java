package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.HomePage;
import amazon.LoginPage;
import amazon.SignInPage;
import base.BaseTest;

public class AmazonLoginTest extends BaseTest
{
	
	SignInPage signinpage;
	LoginPage loginpage;
	HomePage homepage;

	@Test(dataProvider = "DATA")
	public void amazonLoginTest(String username,String password)
	{
		
		signinpage = new SignInPage(driver);
		signinpage.open();
		loginpage = signinpage.goToLoginPage();
		
		homepage = loginpage.loginWith(username, password);
		homepage.signOut();
		
	}
	
	@DataProvider(name = "DATA")
	public Object[][] getLoginData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "9966973477";
		data[0][1] = "amazon26";
		
		data[1][0] = "8106851390";
		data[1][1] = "sirisha";

		return data;
	}
}
