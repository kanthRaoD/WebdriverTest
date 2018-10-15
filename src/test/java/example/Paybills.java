package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Paybills {

	WebDriver driver;
	@Test
	public void paybills(){
		ExtentReports logger= ExtentReports.get(Paybills.class);
    	logger.init("D:\\Extentreports\\advancedreport.html", true);
    	logger.startTest("Verify Page Title");
		driver.get("http://zero.webappsecurity.com/");  
		logger.log(LogStatus.INFO, "Application is up on running");
		
		String title = driver.getTitle();	
		logger.log(LogStatus.INFO, "title captured");
		System.out.println(title);
		logger.attachScreenshot("C:\\Users\\M1047765\\Pictures\\xpath-selenium.png");
		try {
			Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test(priority=2)
	//	@Parameters("User_name")
		//(groups = { "login"})	
		public void login()
		{
			ExtentReports logger1= ExtentReports.get(Paybills.class); 
			driver.findElement(By.xpath("//*[@id='signin_button']")).click();
			logger1.log(LogStatus.INFO, "click on signin button");
			driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");;
			logger1.log(LogStatus.INFO, "Enter username");
			driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
			logger1.log(LogStatus.INFO, "Enter password");
			driver.findElement(By.xpath("//*[@id='login_form']/div[2]/input")).click();
		logger1.log(LogStatus.INFO, "click on login button");
		}
	@Test(priority=3)
	
	public void navigatebackword() throws InterruptedException
	{
	//	ExtentReports logger2= ExtentReports.get(NewTest.class); 	
	driver.navigate().back();
	//logger2.log(LogStatus.INFO, "Navigate backword");
	Thread.sleep(10000);
	}
	
	
	@Test(priority=4)
	
	public void onlinebanking()
	{
		//ExtentReports logger3= ExtentReports.get(NewTest.class); 
		driver.findElement(By.xpath("//*[@id='onlineBankingMenu']/div/strong")).click();
	//	logger3.log(LogStatus.INFO, "click on online banking");
	}
	
	@Test(priority=5)
	public void paybills1() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
		Select selectpayee=new Select(driver.findElement(By.xpath("//*[@id='sp_payee']")));
		selectpayee.selectByIndex(2);
		
		Select selectaccount=new Select(driver.findElement(By.xpath("//*[@id='sp_account']")));
		selectaccount.selectByIndex(2);
		driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("100");;
		driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("12/12/2018");;
		
		driver.findElement(By.xpath("//*[@id='sp_description']")).sendKeys("send amount");;
		driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
		
		
		
		
		
	}
	
	
	
	
	@BeforeTest
	public void beforeTest() {	
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");  
	    driver = new ChromeDriver();
	   // driver.manage().window().maximize();
	   // logger.log(LogStatus.INFO, "Browser is up on running");
	}		
	@AfterTest
	public void afterTest() {
		ExtentReports logger5= ExtentReports.get(Paybills.class); 
		driver.quit();	
		logger5.endTest();
	}
}
