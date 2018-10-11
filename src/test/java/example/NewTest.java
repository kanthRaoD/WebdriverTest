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
public class NewTest {		
	    private WebDriver driver;		
	    
	    @Test
	     public void invokebrowser() {	
	    	
	    	ExtentReports logger= ExtentReports.get(NewTest.class);
	    	logger.init("D:\\Extentreports\\advancedreporting.html", true);
	    	logger.startTest("Verify Page Title");
			driver.get("http://zero.webappsecurity.com/");  
			logger.log(LogStatus.INFO, "Application is up on running");
			
			String title = driver.getTitle();	
			logger.log(LogStatus.INFO, "title captured");
			Assert.assertTrue(title.contains("zero"));
			logger.log(LogStatus.INFO, "title is verified");
			System.out.println(title);
			logger.attachScreenshot("D:\\Extentreports\\screenshots\\xpath-selenium.png");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			logger.endTest();		
		}	
		
	
		
		@Test
		@Parameters("User_name")
		//(groups = { "login"})	
		public void login(String User_name)
		{
			
			driver.findElement(By.xpath("//*[@id='signin_button']")).click();
			
			driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys(User_name);;
			
			driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
			
			driver.findElement(By.xpath("//*[@id='login_form']/div[2]/input")).click();
		}
		
		@Test
		
		public void navigatebackword()
		{
		driver.navigate().back();
		}
		
		@Test(dependsOnMethods ={"navigatebackword"})
		
		public void onlinebanking()
		{
			driver.findElement(By.xpath("//*[@id='onlineBankingMenu']/div/strong")).click();
		}
		
		
		@Test(dependsOnMethods ={"onlinebanking"})
	
		public void transferfunds()
		{
			driver.findElement(By.xpath("//*[@id='transfer_funds_link']")).click();
			Select fromaccount=new Select(driver.findElement(By.xpath("//*[@id='tf_fromAccountId']")));
			fromaccount.selectByIndex(2);
			Select toaccount=new Select(driver.findElement(By.xpath("//*[@id='tf_fromAccountId']")));
			toaccount.selectByIndex(2);
			
			driver.findElement(By.xpath("//*[@id='tf_amount']")).sendKeys("100");
			driver.findElement(By.xpath("//*[@id='tf_description']")).sendKeys("transfer funds");
			driver.findElement(By.xpath("//*[@id='btn_submit']")).click();
			
			driver.findElement(By.xpath("//*[@id='btn_submit']")).click();
			
			WebElement element=driver.findElement(By.xpath("//*[@id='transfer_funds_content']/div/div/div[1]"));
			
		
			
			if(	element.getText().equalsIgnoreCase("You successfully submitted your transaction."))
			{
				System.out.println("pass");
			}else
			{
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
			driver.quit();			
		}		
}	
