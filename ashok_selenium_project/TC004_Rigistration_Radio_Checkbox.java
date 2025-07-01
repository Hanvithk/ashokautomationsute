package ashok_selenium_project;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Rigistration_Radio_Checkbox {

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
	public void tc001() {
	
		driver.findElement(By.name("fld_username")).sendKeys("Kareti");
		driver.findElement(By.xpath("//input[@name='add_type' and @value='office']")).click(); //Radio button
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();  // Check box
		
		

	}
}
