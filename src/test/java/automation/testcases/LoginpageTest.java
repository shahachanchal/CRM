package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.TestBase;
import automation.pages.Loginpage;
import automation.pages.Homepage;

public class LoginpageTest extends TestBase {

	Loginpage Loginpage;
	Homepage HomePage;

	LoginpageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		Loginpage = new Loginpage();

	}

	@Test(priority = 1)
	public void LoginpageTitleTest() {
		String firstpageTitle = Loginpage.validateloginPageTitle();
		Assert.assertEquals(firstpageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 3)
	public void LoginTest() {
		HomePage = Loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 2)
	public void LogoTest() {
		boolean flag = Loginpage.validateLogo();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
