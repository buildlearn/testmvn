package myapp.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Launch {
	
	public String baseUrl = "http://demo.guru99.com/selenium/delete_customer.php";
	String driverPath = "C:\\YASIR\\Learning\\chromedriver.exe";
    public WebDriver driver ; 
    
	@Test(priority=0)
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
	}
	
	  @AfterTest
 	  public void terminatebrowser() {
 	driver.close();
 	  }
    
}