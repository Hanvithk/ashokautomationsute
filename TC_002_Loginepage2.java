package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_Loginepage2 {

	@Test
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("ashok");
		driver.findElement(By.id("pass")).sendKeys("ashok123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.quit();
	}
}
