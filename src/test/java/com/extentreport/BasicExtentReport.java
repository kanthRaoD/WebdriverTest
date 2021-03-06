package com.extentreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.LogStatus;

import example.NewTest;
 
public class BasicExtentReport {
    private WebDriver driver;	
	//builds a new report using the html template 
    ExtentHtmlReporter htmlReporter;
    
    ExtentReports extent;
    //helps to generate the logs in test report.
    ExtentTest test;
    
    @Parameters({ "OS", "browser" })
    @BeforeTest
    public void startReport(String OS, String browser) {
    	// initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport1.html");
        
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);
        
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Mindtree");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");  
	    driver = new ChromeDriver();
    }
     
    @Test
    public void invokebrowser() throws InterruptedException {
    	driver.get("http://zero.webappsecurity.com/");  
    	
		Thread.sleep(10000);
		String title = driver.getTitle();	
		
	//	Assert.assertTrue(title.contains("Zero - Personal Banking"));
	//	logger.log(LogStatus.PASS, "title is verified");
		System.out.println("title" +title);
		if(title.equalsIgnoreCase("Zero - Personal Banking - Loans - Credit Cards"))
		{
        test = extent.createTest("Invoke Browser", "PASSED test case");
        Assert.assertTrue(true);
		}
		else{
			 test = extent.createTest("Invoke Browser", "Failed test case");
			 Assert.assertTrue(false);
		}
    }
    
    @Test
    public void login() throws InterruptedException {
    	
    	
		driver.findElement(By.xpath("//*[@id='signin_button']")).click();
		
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");;
		
		driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//*[@id='login_form']/div[2]/input")).click();
		driver.navigate().back();
	
		Thread.sleep(10000);
	String pagesource=	driver.getTitle();
	System.out.println("pagesource" +pagesource);
	if(pagesource.contentEquals("Zero - Personal Banking - Loans - Credit Cards"))
	{
        test = extent.createTest("Login", "PASSED test case");
        Assert.assertTrue(true);
	}
	else{
		test = extent.createTest("Login", "Failed test case");
        Assert.assertTrue(false);
	}
    }
    
    @Test
    public void fundtransfer() {
        test = extent.createTest("Fund_Transfer", "PASSED test case");
        Assert.assertTrue(true);
    }
     
  @Test
    public void paybills() {
        test = extent.createTest("PayBills", "PASSED test case");
        Assert.assertTrue(true);
    }
     
   // @Test
    public void moneymap() {
        test = extent.createTest("Test Case 5", "SKIPPED test case");
        throw new SkipException("Skipping this test with exception");
    }
    
    @Test(enabled=false)
	public void testCase6(){
			test = extent.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
		}
   
    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
    	driver.close();
      //  extent.flush();
       
    }
}