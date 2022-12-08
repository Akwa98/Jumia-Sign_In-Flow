import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JumiaOrderFlowTest {

    //import the selenium driver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the ChromeDriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome Browser
        driver = new ChromeDriver();
        //2. Input the Jumia page URL(https://www.jumia.com.ng/)
        driver.get("https://www.jumia.com.ng/");
        //3. Maximize the window
        driver.manage().window().maximize();
        if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            //Pass
            System.out.println("Correct Webpage URL");
        else
            //Fail
            System.out.println("Wrong URL");
        //Get the page title
        System.out.println(driver.getTitle());
    }
  

   @Test(priority = 0)
    public void Negative_Signin() throws InterruptedException {
        // Click the account Button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        // 2. Click the sign In Button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        Thread.sleep(2000);
        //3. Locate the email address field Insert an invalid Email Address
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("jamesmail.com");
        // press the login button
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(2000);
        //Test for email Validity
        WebElement query = driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input"));
        query.sendKeys("jamesmail.com");
        query.clear();
       if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/elBNZ4-lO9TQ__epu9-EZ/en-ng/sign-in/"))
           //Pass
           System.out.println("Invalid Email");
       else
           //Fail
           System.out.println("Error");

    }

    @Test(priority = 1)
    public void Positive_Signin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Locate the email address field Insert valid Email Address
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("acousins3v@yahoo.co.jp");
        // press the
        driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
        Thread.sleep(3000);
        //Test for email Validity
            if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/elBNZ4-lO9TQ__epu9-EZ/en-ng/sign-in/"))
                //Pass
                System.out.println("Invalid Email");
            else
                //Fail
                System.out.println("Error");
    }

    @Test(priority = 2)
    public void Negative_Password() throws InterruptedException {
        //4. Locate the password field and insert an invalid password
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("m4chris");
        //5 Press the login button
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        //Invalid Password Test
        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = "https://my.jumia.com.ng/interaction/q3gB1c8nJhdHiuDkPbJqo/en-ng/sign-in";
        if(expectedUrl.contains(actualUrl))
            //Pass
            System.out.println("Correct Password");
        else
            //Fail
            System.out.println("Invalid Password");
        WebElement query = driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input"));
        ((WebElement) query).sendKeys("m4christ");
        query.clear();
    }

    @Test(priority = 3)
    public void Positive_Password() throws InterruptedException {
        //4. Locate the password field and insert valid password
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("5mzwOKYb17YX");
        //5 Press the login button
        driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
        //Valid Password Test
        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = "https://my.jumia.com.ng/interaction/q3gB1c8nJhdHiuDkPbJqo/en-ng/sign-in";
        if(expectedUrl.contains(actualUrl))
            //Pass
            System.out.println("Correct Password");
        else
            //Fail
            System.out.println("Invalid Password");


    }

    @Test(priority = 4)
    public void LogOut() throws InterruptedException {
        // 6 Click the account button
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
        // 7 click the logout button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();

    }

@AfterTest
        public void closeBrowser() {
        //Quit the browser
        driver.quit();


    }
}


/**driver.get("https://www.jumia.com.ng/");
 driver.navigate().refresh();
 Thread.sleep(5000);*/