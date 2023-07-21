package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	@Test
	public void Demo() {
		System.out.println("********Program Starts ***********");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.chitaledairy.com/webmail/logon");
		
		
		driver.findElement(By.xpath("//img[@class='large-banner']")).isDisplayed();
				
		System.out.println("**********Program Ends**************");
	}
}
