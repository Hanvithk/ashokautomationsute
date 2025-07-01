package ashok_selenium_project;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_Homepage_Fatchdata_from_Browser {

	ChromeDriver driver;  // Chromedriver declared as a globally
	
	@BeforeMethod
	public void startBrowse() throws InterruptedException {
	    //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to("https://thetestingworld.com/testings/");	
		 
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}
	@Test
	public void tc001() throws InterruptedException {
	
		driver.findElement(By.name("fld_username")).sendKeys("Kareti");
		
		System.out.println("Factching the Curent Url form the Browser----->  " + driver.getCurrentUrl()); 
		System.out.println("Titile of the page---> " +driver.getTitle());
		System.out.println("Html of the page:-----" + driver.getPageSource());
	    
	}
}
