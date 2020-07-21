package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SecurePage;

public class LoginTest extends BaseTest
{

	protected LoginPage  objLogin;
	protected SecurePage objSecurePage;
	
	@Test
	public void loginTest()
	{
		objLogin = new LoginPage(driver);
		objLogin.open();
		objSecurePage = objLogin.LoginWith("tomsmith", "SuperSecretPassword!");

	}
	
	@Test(dependsOnMethods = "loginTest")
	public void logOutTest()
	{
		Assert.assertTrue(objSecurePage.isLoggedIn());
		objSecurePage.DoLogout();
	}
	

}
