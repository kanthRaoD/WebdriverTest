package example;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test(priority=1)	
		@Parameters("myName")
		public void testEasy(String myName) {	
			driver.get("http://zero.webappsecurity.com/");  
			String title = driver.getTitle();	
			System.out.println(title);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("Parameterized value is : " + myName);
			//Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		}	
		
	//	@Test(priority=2)
		@Parameters("myName")
		public void testvalidate(String myName) {	
			 
				driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/a")).click();
		}	
		
		
		@Test(priority=3)
		public void login()
		{
			driver.findElement(By.xpath("//*[@id='signin_button']")).click();
			
			driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");;
			
			driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
			
			driver.findElement(By.xpath("//*[@id='login_form']/div[2]/input")).click();
		}
		
		
		
		
		
		
		@BeforeTest
		public void beforeTest() {	
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");  
		    driver = new ChromeDriver();
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	
