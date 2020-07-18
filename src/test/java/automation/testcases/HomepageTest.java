package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.TestBase;
import automation.pages.Homepage;
import automation.pages.Loginpage;
import automation.pages.Contactpage;
import automation.utils.testUtils;
public class HomepageTest extends TestBase{
	
	Loginpage Loginpage;
    Homepage Homepage;
    testUtils testUtils;
    Contactpage Contactspage;
     
	HomepageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtils = new testUtils();
		Loginpage =new Loginpage();
		Contactspage = new Contactpage();
		 
		Homepage= Loginpage.login(prop.getProperty("username"),prop.getProperty("password"));

		System.out.println("step1 ");

    }
    
	@Test(priority = 1)
	public void ValidateHomepageTitleTest() {
		
		String HomepageTitle= Homepage.VerifyHomepageTitle();
		System.out.println(HomepageTitle);
		Assert.assertEquals(HomepageTitle, "CRMPRO","home page title not match");

		  
	 }
	

	 
	@Test(priority = 2)
	public void ValidateUsernameDisplayTest() {
         
		testUtils.switchToFrame();
		Assert.assertTrue(Homepage.Usernamedisplay());
		System.out.println("step4");
	}

	
	@Test(priority = 3)
	public void VerifyClickonContactsLinkTest() {
		testUtils.switchToFrame();
		Contactspage=Homepage.ClickonContactsLink();
		
	}
	
	@AfterMethod
	 public void TearDown() {
		System.out.println("step3 ");
	     driver.quit();
	}

  
  
}
