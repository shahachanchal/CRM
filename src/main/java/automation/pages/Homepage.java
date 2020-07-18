package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.base.TestBase;

public class Homepage extends TestBase {
	
	@FindBy(xpath="//a[@href='https://classic.freecrm.com/system/index.cfm?action=contact']")
	WebElement contactsLink;
	
	@FindBy(xpath="//td[contains(text(),'Demo User')]") 
	WebElement loginUsername;
	
	@FindBy(xpath="//a[contains(@title,'Companies')]")
	WebElement CompaniesLink;
	
	@FindBy(xpath="//a[contains(@title,'Deals')]")
	WebElement DealsLink;
	
	
	public Homepage(){
		PageFactory.initElements(driver, this);		
	}

	public String VerifyHomepageTitle() {
	
		return driver.getTitle();
	}
	
	
	
	public boolean Usernamedisplay() {
		return loginUsername.isDisplayed();
	}
	
	public Contactpage ClickonContactsLink() {
		
		 contactsLink.click();
		 return new  Contactpage();
		 }
	
	
	public Companiespage ClickonCompaniesLink() {
		
		CompaniesLink.click();
		return new Companiespage();
		 }
	
	public Dealpage ClickonDealsLink() {
		
		DealsLink.click();
		return new Dealpage();
		 }
	
}
