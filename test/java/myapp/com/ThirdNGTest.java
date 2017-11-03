package myapp.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ThirdNGTest {
	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
    String driverPath = "C:\\YASIR\\Learning\\geckodriver.exe";
    public WebDriver driver ; 
    String expected = null;
     
  @BeforeTest  
  public void launchbrowser() {
	   System.out.println("launching firefox browser"); 
	   System.setProperty("webdriver.firefox.marionette", driverPath);
	   driver = new FirefoxDriver();
	   driver.get(baseUrl);
	   driver.manage().window().maximize();
  }
  @Test(priority=4)
  public void verifyRegister() {
       
	  WebElement Reg = driver.findElement(By.linkText("REGISTER"));
	  Reg.click();
      String expected = "Register: Mercury Tours";
      Assert.assertEquals(driver.getTitle(), expected);
     }
  
  @Test(priority=0)
  public void verifySupport() {
      
	  WebElement Supp = driver.findElement(By.linkText("SUPPORT"));
	  Supp.click();
      String expected = "Under Construction: Mercury Tours";
      Assert.assertEquals(driver.getTitle(), expected);
  }
  
  @AfterTest
  public void terminatebrowser() {
	  driver.close();
  }
}
