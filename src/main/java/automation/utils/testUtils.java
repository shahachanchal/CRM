package automation.utils;



import automation.base.TestBase;

public class testUtils extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICIT_WAIT=50;



	public void switchToFrame(){

		driver.switchTo().frame("mainpanel");

	}

}
