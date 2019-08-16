import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;


public class NewTest {

    private WebDriver driver;

    @BeforeTest
    public void launch() {
        //System.out.println("launching Mozilla FireFox browser");
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\tiju thomas\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "/home/testing/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
        //FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(false);
        //driver = new FirefoxDriver(options);
        System.out.println("launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tiju thomas\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
    }


    @Test(priority = 1)
    public void openFFbrowser() throws Exception {
        driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
        driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
        driver.findElement(By.name("password")).sendKeys("adda12345");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("submit_login")).click();
        //this.takeSnapShot(driver, "/tmp/adda.png");
    }

    //@Test(priority=2)
    public void CheckIn() throws Exception {
        driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Block 1-002')]")).click();
        driver.findElement(By.xpath("//tr"));
        driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
        driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
       // this.takeSnapShot(driver, "/tmp/checkin.png");
        Thread.sleep(5000);

    }

    //@Test(priority=3)
    public void CheckOut() throws Exception {
        driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
        driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
       // this.takeSnapShot(driver, "/tmp/checkout.png");
        Thread.sleep(5000);
    }


    // @Test(priority=3)
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception



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
     */