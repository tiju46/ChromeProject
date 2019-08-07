
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

 
public class NewTest {
 
	WebDriver driver;
 
  
  @Test(priority=1)
  public void launchbrowser() {
	  System.out.println("launching Mozilla FireFox browser");
	  System.setProperty("webdriver.gecko.driver","/home/testing/Downloads/geckodriver-v0.24.0-linux64");
	  FirefoxOptions options = new FirefoxOptions();
	  options.setCapability("marionette", false);
	  driver = new FirefoxDriver(options);
  }
   
  
 //@Test(priority=2)
  public void openFFbrowser() {
		driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
		driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
	    driver.findElement(By.name("password")).sendKeys("adda12345");
	   
	    //click on login button
	    driver.findElement(By.id("submit_login")).click();
	}
// @Test(priority=3)
 public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}
 
}