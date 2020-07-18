package automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.utils.testUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	
	try {
	 prop= new Properties();
	FileInputStream ip=new FileInputStream("C:/Users/chanchals/Desktop/Automation/automation/src/main/java/automation/config/config.properties");
	prop.load(ip);
	}
	
	catch(FileNotFoundException e ){e.printStackTrace();
	}
	catch(IOException e ){
		e.printStackTrace();
	}
	
	}
	
	public static void initialization()
	{
		String browserName= prop.getProperty("browser");
		String URL = prop.getProperty("url");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/chanchals/Desktop/Automation/chromedriver.exe");
			 driver=new ChromeDriver();
		} else 
			
			{System.out.println("no browser");
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(URL);
	}
	
	
	
}
