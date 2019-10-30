import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;



public class NewTest {

    private WebDriver driver;

    @BeforeTest
    public void launch() {
       
        System.out.println("launching Chrome browser");
        //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver77\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/home/testing/Downloads/chromedrvr/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
    }


    @Test(priority = 1)
    public void openChromebrowser() throws Exception {
        driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("thomastiju@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("adda1234");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("submit_login")).click();
        //this.takeSnapShot(driver, "/tmp/adda.png");
    }

  // @Test(priority=2)
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

   //@Test(priority=3)
    public void CheckOut() throws InterruptedException {
	   driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
       driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
       System.out.println("Test Case Passed ----- Visitor Checked Out");
       Thread.sleep(5000);
    }
   
   @Test(priority=4)
   public void staffcheckin() throws InterruptedException {
	   driver.findElement(By.xpath("//p[contains(text(),'Staff')]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//a[@class='nav-link active-cm']")).click();
	   //driver.findElement(By.xpath("//span[@class='input-group-text']")).click();
	   driver.findElement(By.xpath("//input[@id='visiter_search']")).sendKeys("john");
	   Thread.sleep(3000);
       driver.findElement(By.xpath("//*[contains(text(),'Search')]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[contains(text(),'CHECK IN')]")).click();
       System.out.println("Test Case Passed ----- Staff Checked In");
	   Thread.sleep(4000);
   }
   
   @Test(priority=5)
   public void staffcheckout() throws InterruptedException {
      // driver.findElement(By.xpath("//span[@class='input-group-text']")).click();
	   driver.findElement(By.xpath("//input[@id='visiter_search']")).sendKeys("john");
	   Thread.sleep(2000);
       driver.findElement(By.xpath("//*[contains(text(),'Search')]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[contains(text(),'CHECK OUT')]")).click();
       System.out.println("Test Case Passed ----- Staff Checked Out");
	   Thread.sleep(4000);
   }

    @Test(priority=6)
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