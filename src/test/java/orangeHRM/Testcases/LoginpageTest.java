package orangeHRM.Testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginpageTest {
	WebDriver driver;	
	Logger log=Logger.getLogger(LoginpageTest.class);
	
	@BeforeMethod
	public void setup() {
		log.info("launching the browser");
		System.setProperty("webdriver.chrome.driver", "D:\\rkreddy\\rkrworkspace\\drivers\\src\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() throws InterruptedException {
		log.info("entering url");
		driver.get("http://apps.qaplanet.in/hrm/login.php");
		log.warn("url entered");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		log.error("browser maximized");
		//verify homepage
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management")){
		System.out.println("correct title displayed");
		
		}else
		{
		System.out.println("Incorrect title displayed");
		}
		log.fatal("Title displayed");
		//verify UN,PWD,Login & clear
		//create webelement
		WebElement objUN = driver.findElement(By.name("txtUserName"));
		WebElement objPWD = driver.findElement(By.name("txtPassword"));
		WebElement objLogin = driver.findElement(By.name("Submit"));
		WebElement objClr = driver.findElement(By.name("clear"));
		if(objUN.isDisplayed()){
		System.out.println("Username present");
		}
		if(objPWD.isDisplayed()){
		System.out.println("Password present");
		}
		if(objLogin.isDisplayed() && objClr.isDisplayed()){
		System.out.println("Login and Clear are present");
		}
		//Enter valid UN,PWD & click on login
		String UN = "qaplanet1";
		String PWD = "lab1";
		objUN.sendKeys(UN);
		objPWD.sendKeys(PWD);
		objLogin.click();
		//verify Orhrm displayed
		if(driver.getTitle().equals("OrangeHRM")){
		System.out.println("Orhrm page displayed correctly");
		}else
		{
		System.out.println("Orhrm page not displayed correctly");
		}
		       //verify Welcome UN,change password and Logout
		String wel = driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		if(wel.equals("Welcome "+UN)){
		System.out.println("Welcome qaplanet1 displayed");
		}else{
		System.out.println("Welcome UN doesn't displayed");
		}
	
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
