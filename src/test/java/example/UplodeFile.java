package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class UplodeFile {
	WebDriver driver;
	 @Test
	public void UploadFileUsingSendKeys()
			throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");  
		    driver = new ChromeDriver();
		    /*System.setProperty("webdriver.ie.driver","C:\\IEdriver\\IEDriverServer.exe");  
		    driver = new InternetExplorerDriver();*/
		    driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");
		    //Locating 'browse' button
		    WebElement browse =driver.findElement(By.id("uploadfile"));
		    //pass the path of the file to be uploaded using Sendkeys method
		    browse.sendKeys("C:\\IEdriver\\new.txt");
		    //'close' method is used to close the browser window
		    driver.close();
	}
	
/*	public static void main(String args[])
	{
		UplodeFile uplodefile = new UplodeFile();
		try {
			uplodefile.UploadFileUsingSendKeys();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
