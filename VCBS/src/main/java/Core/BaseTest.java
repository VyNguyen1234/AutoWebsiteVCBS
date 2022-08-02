package Core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTest {
    public WebDriver driver;
    String chromeDriver = "D:\\VyNguyen\\Setup\\chromedriver.exe";
   // String fireFox = "C:\\AUTOMATION TEST\\geckodriver.exe";
    String url = "https://uat.vcbs.com.vn/DEPLOY_OnlineTrading/";
    @BeforeTest
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);


        //run with FireFox browser
//        System.setProperty("webdriver.gecko.driver",fireFoxDriver);
//        driver = new FirefoxDriver();
//        driver.get(url);
//        driver.manage().window().maximize();

    }
    //@AfterTest
//    public void down(){
//        driver.close();
//    }
}
