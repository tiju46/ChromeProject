import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.io.File;


public class NewTest {

    private WebDriver driver;


    @Test(priority = 1)
    public void launchbrowser() {
        System.out.println("launching Mozilla FireFox browser");
        System.setProperty("webdriver.gecko.driver", "/home/testing/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
    }


    @Test(priority=2)
    public void openFFbrowser() throws Exception {
        driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
        driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
        driver.findElement(By.name("password")).sendKeys("adda12345");

        //click on login button
        driver.findElement(By.id("submit_login")).click();
        this.takeSnapShot(driver, "/tmp/adda.png") ;
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