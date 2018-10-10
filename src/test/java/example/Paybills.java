package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Paybills {
   // test case 1
   @Test
   public void testCase1(){
	   
     
   }

   // ignore test
   @Test(enabled = false)
   public void testCase2() {
      System.out.println("in test case 2");
   }

 



 

   

}
