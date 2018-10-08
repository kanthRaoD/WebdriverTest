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
		public void testEasy() {	
			driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getTitle();	
			System.out.println(title);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		}	
		
		@Test(priority=2)
		@Parameters("myName")
		public void testvalidate(String myName) {	
			 System.out.println("Parameterized value is : " + myName);
				//driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/a")).click();
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
