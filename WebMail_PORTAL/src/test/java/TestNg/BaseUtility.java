package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {

private WebDriver driver;
	
	public WebDriver Startup (String bName, String url) {
		  
		if (bName.equalsIgnoreCase("ch")|| bName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver ();
		
		}else if (bName.equalsIgnoreCase("FF") || bName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			 driver = new FirefoxDriver ();
		} else if (bName.equalsIgnoreCase("Edge")) {
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		 driver = new EdgeDriver ();
		}else {
			System.out.println("Invalid Browser Name......!!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		return driver;
		
	}

	public void waitForVisiblityOfElement (WebDriver driver, int time, WebElement ele) {
		WebDriverWait wt = new WebDriverWait (driver, Duration.ofSeconds (time) ) ;
		wt.until (ExpectedConditions.visibilityOf(ele));
		}
		public void waitForVisiblityOfElementLocated(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait (driver, Duration.ofSeconds (time));
		switch(type) {
		case "id": wt.until (ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		break;
		case "clss": wt.until (ExpectedConditions.visibilityOfElementLocated (By.className (locator)));
		break;
		case "xpath": wt.until (ExpectedConditions.visibilityOfElementLocated(By.xpath (locator)));
		break;
		case "css": wt.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector (locator)));
		break;

		}
}
		

		public void scrollByJS(WebDriver driver, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", ele);
		}
		
		public void clickeByJS(WebDriver driver, WebElement ele) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
		
			}

		public boolean isAlertPresent(WebDriver driver, int i) {
			return false;
		}
}
