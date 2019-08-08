import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class NewTest {

    private WebDriver driver;


    public void launchbrowser() {
        System.out.println("launching Mozilla FireFox browser");
        System.setProperty("webdriver.gecko.driver", "/home/testing/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
    }


    @Test(priority=1)
    public void openFFbrowser() throws InterruptedException {
        driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
        driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
        driver.findElement(By.name("password")).sendKeys("adda12345");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click on login button
        driver.findElement(By.id("submit_login")).click();
        //this.takeSnapShot(driver, "/tmp/adda.png") ;
    }
	@Test(priority=2)
	public void CheckIn() throws InterruptedException {
		driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Block 1-002')]")).click();
		driver.findElement(By.xpath("//tr"));
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
		//Wait for 5 Sec
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
		driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
		//this.takeSnapShot(driver, "/tmp/checkin.png") ;
		Thread.sleep(5000);

	}
	@Test(priority=3)
	public void CheckOut() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
		driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
		//this.takeSnapShot(driver, "/tmp/checkout.png") ;
		Thread.sleep(5000);
	}


    // @Test(priority=3)
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
}