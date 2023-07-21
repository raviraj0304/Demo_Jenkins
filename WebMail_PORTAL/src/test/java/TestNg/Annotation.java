package TestNg;

import org.configue.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.LoginPage;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Annotation {
		
	private String url;
	private String uName;
	private String pwd;
	private WebDriver driver;
	LoginPage obj;
	ConfigReader cr = new ConfigReader();
	
	@BeforeSuite
	public void setup () {
		ConfigReader cr = new ConfigReader();
		url=cr.getTestData("url");
		uName=cr.getTestData("username");
		pwd=cr.getTestData("password");
	}
	
	@BeforeMethod
	public void OpenPortal() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
	}
		
	@Test(priority=0)
	public void verifyLoginPage() throws InterruptedException {
		Thread.sleep(3000);
		 obj= new LoginPage(driver);
		obj.uNameFielddisplayed();
		obj.pwdFielddisplayed();
		obj.loginFielddisplayed();
		
		Reporter.log("Login Page Validate Seccessfully");
	}
	
	@Test(priority=1)
	public void validateLogin() throws Exception  {
		Thread.sleep(3000);
		obj=new LoginPage(driver);
		obj.enterUserName();
		obj.enterpassword();
		obj.clickOnLoginBtn();
		
		Reporter.log("Login Successfully");
	}

	
	@AfterSuite
	public void teardown1() throws Exception {
		obj=new LoginPage(driver);
		Thread.sleep(5000);
		obj.beforeclickOnLogoutBtn();
		Thread.sleep(3000);
		obj.clickOnLogoutBtn();
		driver.close();
		
	}
}