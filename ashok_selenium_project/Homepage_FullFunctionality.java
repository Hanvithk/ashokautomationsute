package ashok_selenium_project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage_FullFunctionality {
	ChromeDriver driver;
	@BeforeMethod
	public void homepage() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.navigate().to("https://thetestingworld.com/testings/");
		driver.manage().window().maximize();
	}
	
	
	public void startbrowser() throws InterruptedException {
		driver.findElement(By.name("fld_username")).sendKeys("Goprajuga");
		driver.findElement(By.name("fld_email")).sendKeys("Goprajuga@gmail.com");
		driver.findElement(By.name("fld_password")).sendKeys("Goprajuga12");
		driver.findElement(By.name("fld_cpassword")).sendKeys("Goprajuga12");
		driver.findElement(By.name("dob")).sendKeys("11/12/2001");
		driver.findElement(By.name("phone")).sendKeys("9496552369");
		driver.findElement(By.name("address")).sendKeys("Nellore");
		driver.findElement(By.xpath("//input[@name='add_type' and @type='radio']")).click();
		
		Select gender = new Select(driver.findElement(By.xpath("//select[@name='sex']")));
		gender.selectByVisibleText("Male");
		Thread.sleep(5000);
		Select country = new Select(driver.findElement(By.id("countryId")));
		country.selectByVisibleText("India");
		Thread.sleep(5000);
		Select state = new Select(driver.findElement(By.id("stateId")));
		state.selectByVisibleText("Andhra Pradesh");
		Thread.sleep(5000);
		Select city = new Select(driver.findElement(By.id("cityId")));
		city.selectByVisibleText("Nellore");
		
		driver.findElement(By.name("zip")).sendKeys("524345");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Test
	public void loginfunctionality() {
		
		driver.findElement(By.xpath("//label[text()='Login']")).click();
		driver.findElement(By.name("_txtUserName")).sendKeys("Goprajuga");
		driver.findElement(By.name("_txtPassword")).sendKeys("Goprajuga12");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		 
	}

}
