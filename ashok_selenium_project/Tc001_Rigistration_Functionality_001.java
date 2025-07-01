package ashok_selenium_project;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc001_Rigistration_Functionality_001 {

	ChromeDriver driver;  // Chromedriver declared as a globally
	
	@BeforeMethod
	public void startBrowse() throws InterruptedException {
	    //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to("https://google.com");
		 driver.navigate().to("https://thetestingworld.com/testings/");
		//driver.get("https://thetestingworld.com/testings/");
		 driver.navigate().back();
		 Thread.sleep(5000);
		 driver.navigate().forward();
		 Thread.sleep(5000);
		 driver.navigate().refresh();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}
	@Test
	public void tc001() {
	
		driver.findElement(By.name("fld_username")).sendKeys("Muruganswami");
		driver.findElement(By.name("fld_email")).sendKeys("muruganswami@gmail.com");
		driver.findElement(By.name("fld_password")).sendKeys("muruganswami");
		driver.findElement(By.name("fld_cpassword")).sendKeys("muruganswami"); 
		driver.findElement(By.name("dob")).sendKeys("12/12/2001");
		driver.findElement(By.name("phone")).sendKeys("7671010859");
		driver.findElement(By.name("address")).sendKeys("Bangalore");
		
		
	}
}
