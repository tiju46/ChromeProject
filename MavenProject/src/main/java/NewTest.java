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
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\tiju thomas\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/home/testing/Downloads/chromedrvr/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
    }


    @Test(priority = 1)
    public void openFFbrowser() throws Exception {
        driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
        driver.findElement(By.name("email")).sendKeys("thomastiju@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("adda1234");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("submit_login")).click();
        //this.takeSnapShot(driver, "/tmp/adda.png");
    }

    @Test(priority=2)
    public void CheckIn() throws InterruptedException {
        System.out.println("*****--- Expected Visitor ---*****");
        driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'200-15')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
        driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
        System.out.println("Test Case Passed ----- Visitor Checked In");
        Thread.sleep(5000);
    }

    @Test(priority=3)
    public void CheckOut() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
        driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
        System.out.println("Test Case Passed ----- Visitor Checked Out");
        Thread.sleep(5000);
    }
    //@Test(priority=4)
    public void staffcheckin() throws InterruptedException {
        driver.findElement(By.xpath("//p[contains(text(),'Staff')]")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
        Thread.sleep(5000);
        System.out.println("Test Case Passed ----- Staff Checked In");
    }
    //@Test(priority=5)
    public void staffcheckout() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='#/staff/staff-out']")).click();
        driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK OUT')]")).click();
        Thread.sleep(5000);
        System.out.println("Test Case Passed ----- Staff Checked Out");
    }

    @Test(priority=4)
    public void closeDriver() {
        if (driver != null) {
            driver.close();
            System.out.println("######--- Browser Closed ---######");
        }
    }
}

    /**
     tiju
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