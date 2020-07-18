package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.base.TestBase;

public class Contactpage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	public Contactpage(){
		PageFactory.initElements(driver, this);		
	}

	public boolean verifyContactlabel() {
		return contactsLabel.isDisplayed();

	}


	/*public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[Contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();

	}	
*/
}


