package Core;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {
    public static WebDriver driver;
    String chromeDriver = "D:\\VyNguyen\\Setup\\chromedriver.exe";
    // String fireFox = "C:\\AUTOMATION TEST\\geckodriver.exe";
    String url = "https://uat.vcbs.com.vn/DEPLOY_OnlineTrading";

    public static WebDriver getDriver() {
        return driver;
    }

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
    @AfterMethod
    public void tearDown(ITestResult result) {
        Calendar calendar = new GregorianCalendar();
        int y = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int hr = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);

        String takenTime = y + "-" + (month+1) + "-" + day + "-" + hr + "-" + min + "-" + sec;

// Here will compare if test is failing then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
// Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

// Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

// Copy method  specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
                try {
                    FileHandler.copy(source, new File("C:\\Users\\VyNguyen\\IdeaProjects\\VCBS\\ScreenShotTest\\" + result.getName()+takenTime + ".png"));
                    System.out.println("Screenshot taken");
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
                }
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
// close application
            driver.quit();
        }

    }
}
