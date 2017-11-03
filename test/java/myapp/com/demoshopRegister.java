package myapp.com;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demoshopRegister {
	public String baseUrl = "http://demowebshop.tricentis.com";
    public String driverPath = "C:\\YASIR\\Learning\\chromedriver.exe";
    public WebDriver driver ; 
    //public String fname = "Yasir";
    //public String lname = "Anwar";
    //public String email = "chinga@mudglla.com";
    //public String pwd = "123qwe";
    
 @BeforeTest
 @Parameters({"baseUrl"})
 public void launchbrowser (String baseUrl) {
	 System.out.println("launching chrome browser and Demo WebShop"); 
	   System.setProperty("webdriver.chrome.driver", driverPath);
	   driver = new ChromeDriver();
	   driver.get(baseUrl); 
	   driver.manage().window().maximize();
	  }
 
 @Test(priority=8)
 public void clickRegLink() {
	
	 driver.findElement(By.linkText("Register")).click();
	 assertEquals(driver.getCurrentUrl(), "http://demowebshop.tricentis.com/register");
	 System.out.println("Clicking on Register Hyperlink is Successful"); 
 }
 
 @Test(priority=9)
 @Parameters ({"fname", "lname", "email", "pwd"})
 public void userRegistration(String fname, String lname, String email, String pwd ) {
	
	driver.findElement(By.id("gender-male")).click();
	driver.findElement(By.id("FirstName")).sendKeys(fname);
	driver.findElement(By.id("LastName")).sendKeys(lname);
	driver.findElement(By.id("Email")).sendKeys(email);
	driver.findElement(By.id("Password")).sendKeys(pwd);
	driver.findElement(By.id("ConfirmPassword")).sendKeys(pwd);
	driver.findElement(By.id("register-button")).click();
	//String summary = driver.findElement(By.className("validation-summary-errors")).getText();
	//System.out.println(summary);
	driver.findElement(By.linkText("Log out")).click();
 }
 
 @Test(priority=10)
 @Parameters({"email"})
 public void missingPwd(String email) {
	 driver.findElement(By.linkText("Log in")).click();
	 driver.findElement(By.id("Email")).sendKeys(email);
	 driver.findElement(By.cssSelector(".button-1.login-button")).click();
	 String actualerror = driver.findElement(By.className("validation-summary-errors")).getText();
	 Assert.assertEquals(actualerror, "Login was unsuccessful. Please correct the errors and try again.\n"+"The credentials provided are incorrect");
	  
 }
 
 @Test(priority=11)
 @Parameters({"pwd"})
 public void missingEmail(String pwd) {
	 driver.findElement(By.linkText("Log in")).click();
	 driver.findElement(By.id("Password")).sendKeys(pwd);
	 driver.findElement(By.cssSelector(".button-1.login-button")).click();
	 Assert.assertEquals(driver.findElement(By.className("validation-summary-errors")).getText(), "Login was unsuccessful. Please correct the errors and try again.\n"+"No customer account found");
 }
 
 @Test(priority=12)
 @Parameters({"email", "pwd"})
 public void validateNewUser(String email, String pwd) {
	 driver.findElement(By.linkText("Log in")).click();
	 driver.findElement(By.id("Email")).sendKeys(email);
	 driver.findElement(By.id("Password")).sendKeys(pwd);
	 driver.findElement(By.cssSelector(".button-1.login-button")).click();
	 	 
	 	
 }
 
 @AfterTest
 public void closing() {
	driver.close();
 }
 
}
