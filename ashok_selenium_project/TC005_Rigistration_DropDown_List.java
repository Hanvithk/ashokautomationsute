package ashok_selenium_project;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_Rigistration_DropDown_List {

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
		
		Select Gender = new Select(driver.findElement(By.name("sex")));
		Gender.selectByVisibleText("Male");
		Thread.sleep(5000);
		
		Select country = new Select(driver.findElement(By.id("countryId")));
		//country.selectByIndex(10);
		//country.selectByValue("101");
		country.selectByVisibleText("India");
		Thread.sleep(5000);
		Select state = new Select(driver.findElement(By.id("stateId")));
		//state.selectByIndex(2);
		//state.selectByValue("2");
		state.selectByVisibleText("Andhra Pradesh");
		Thread.sleep(5000);
		Select city = new Select(driver.findElement(By.id("cityId")));
		city.selectByIndex(3);
		//city.selectByValue("3");
		city.selectByVisibleText("Nellore");
		driver.findElement(By.name("zip")).sendKeys("524345");
	}
}
