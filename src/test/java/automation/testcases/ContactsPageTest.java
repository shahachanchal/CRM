package automation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.base.TestBase;
import automation.pages.Contactpage;
import automation.pages.Homepage;
import automation.pages.Loginpage;
import automation.utils.testUtils;

public class ContactsPageTest extends TestBase{
	
	Loginpage Loginpage;
    Homepage Homepage;
    testUtils testUtils;
    Contactpage Contactspage;

	
	ContactsPageTest(){
		super();
	}
	

	@BeforeMethod
	public void setup() {
		initialization();
		
		Loginpage =new Loginpage();
		testUtils = new testUtils();
		Contactspage = new Contactpage();
		 
		Homepage= Loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtils.switchToFrame();
		Contactspage=Homepage.ClickonContactsLink();
	

		System.out.println("step1 ");
	}
		
		@Test(priority = 1)
		public void ValidateContactlabelTest() {
			
			Assert.assertTrue(Contactspage.verifyContactlabel(),("Contact label is missing "));
			System.out.println("step2 ");
		}
			
			
			/*@Test(priority=2)
			public void selectContactsTest(){
				System.out.println("step3 ");
			Contactspage.selectContactsByName("abc def");
			}*/

    
			@AfterMethod
			 public void TearDown() {
				System.out.println("step4 ");
			     driver.quit();
			}
	
}
