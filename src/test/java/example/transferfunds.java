package example;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;		
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;		
public class transferfunds {		
	    private WebDriver driver;		
		
	    @Test
	     public void invokebrowser() {	
	    	
	    	ExtentReports logger= ExtentReports.get(transferfunds.class);
	    	logger.init("D:\\Extentreports\\advancedreport.html", true);
	    	logger.startTest("Verify Page Title");
			driver.get("http://zero.webappsecurity.com/");  
			logger.log(LogStatus.INFO, "Application is up on running");
			
			String title = driver.getTitle();	
			logger.log(LogStatus.INFO, "title captured");
			//Assert.assertTrue(title.contains("Zero - Personal Banking"));
			//logger.log(LogStatus.PASS, "title is verified");
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
			ExtentReports logger1= ExtentReports.get(NewTest.class); 
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
	
		public void transferfunds()
		{
			//ExtentReports logger4= ExtentReports.get(NewTest.class); 
			driver.findElement(By.xpath("//*[@id='transfer_funds_link']")).click();
			//logger4.log(LogStatus.INFO, "click on transfer funds links");
			Select fromaccount=new Select(driver.findElement(By.xpath("//*[@id='tf_fromAccountId']")));
			fromaccount.selectByIndex(2);
		//	logger4.log(LogStatus.INFO, "select fromaccount");
			Select toaccount=new Select(driver.findElement(By.xpath("//*[@id='tf_fromAccountId']")));
			toaccount.selectByIndex(2);
		//	logger4.log(LogStatus.INFO, "select to account");
			driver.findElement(By.xpath("//*[@id='tf_amount']")).sendKeys("100");
		//	logger4.log(LogStatus.INFO, "Enter amount");
			driver.findElement(By.xpath("//*[@id='tf_description']")).sendKeys("transfer funds");
		//	logger4.log(LogStatus.INFO, "Enter description");
			driver.findElement(By.xpath("//*[@id='btn_submit']")).click();
		//	logger4.log(LogStatus.INFO, "click on submit button");
				
			driver.findElement(By.xpath("//*[@id='btn_submit']")).click();
			
			WebElement element=driver.findElement(By.xpath("//*[@id='transfer_funds_content']/div/div/div[1]"));
			
		
			
			if(	element.getText().equalsIgnoreCase("You successfully submitted your transaction."))
			{
		//		logger4.log(LogStatus.INFO, "Pass");
				System.out.println("pass");
			}else
			{
		//		logger4.log(LogStatus.INFO, "Fail");
				System.out.println("fail");

			}
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
			ExtentReports logger5= ExtentReports.get(NewTest.class); 
			driver.quit();	
			logger5.endTest();
		}		
}	
