package myapp.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
	public String baseUrl = "http://demo.guru99.com/selenium/delete_customer.php";
	String driverPath = "C:\\YASIR\\Learning\\chromedriver.exe";
    public WebDriver driver ; 
    
	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
	}
	 @Test (priority = 1)
	    public void deleteCustomer(){
		WebElement IDfield = driver.findElement(By.name("cusid"));
		IDfield.sendKeys("321478");
		driver.findElement(By.name("submit")).click();		
	   
	    }
	 	@Test(priority = 2)
	 	public void handleAlerts() {
	 	driver.switchTo().alert().dismiss();
	 	System.out.println("Alert has been cancelled");
	 	driver.findElement(By.name("submit")).click();
	 	String alertMessage = driver.switchTo().alert().getText();
	 	driver.switchTo().alert().accept();
	 	System.out.println("Alert has been Accepted, and this Message is "+alertMessage);
	 	driver.switchTo().alert().accept();
	 	Assert.assertEquals(driver.getTitle(), "Delete Customer");
	 	}
	 	
	 	  @AfterTest
	 	  public void terminatebrowser() {
	 	driver.quit();
	 	  }
	    
}