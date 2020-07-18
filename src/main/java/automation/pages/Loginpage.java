package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.base.TestBase;

public class Loginpage extends TestBase{
	
	//pagefactory - OR
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement Signup;
	
	@FindBy(xpath="//img[@class='img-responsive']" ) //incorrect xpath
	WebElement logo;
	
	
	//Initialize the page objects
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateloginPageTitle()
	{
		return driver.getTitle();
	}

	
	
	
	public Homepage login(String user, String pwd)
	{
	
		username.sendKeys(user);
		password.sendKeys(pwd);
		loginBtn.click();
		return new Homepage();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
}

