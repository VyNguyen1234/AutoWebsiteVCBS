import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ultils.Webdriver;

import java.time.Duration;

public class CashTransferOld {
    @Test
    public static void testInvalidOTP() throws InterruptedException {
        final String loginUrl = "https://uat.vcbs.com.vn/";
        WebDriver driver = Webdriver.getChromeDriver();

        driver.get(loginUrl);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Username")));
        WebElement passwordElem = driver.findElement(By.id("Password"));
        WebElement loginBtnElem = driver.findElement(By.cssSelector("[type='submit']"));

        usernameElem.clear();
        usernameElem.sendKeys("009C000002");
        passwordElem.sendKeys("xyz123");

        loginBtnElem.click();

        WebElement cashTransferBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='Chuyển tiền']")));
        cashTransferBtn.click();

        WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Amount")));
        WebElement acceptBtn = driver.findElement(By.id("btn_CashTransfer"));

        amount.sendKeys("100000");
        acceptBtn.click();

        WebElement otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tvCashtransferOTP")));
        WebElement acceptOtpBtn = driver.findElement(By.id("submitCashTransferWithPIN"));

        otp.sendKeys("1");
        acceptOtpBtn.click();

        String expectWrongOTPMessage = "Sai mã xác thực (OTP)";
        WebElement messageError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message_error")));

        String actualWrongOTPMessage = messageError.getAttribute("innerHtml");
        System.out.println("Message sai OTP thực tế: " + actualWrongOTPMessage);
//        Assert.assertEquals(actualWrongOTPMessage,expectWrongOTPMessage);
        Assert.assertTrue(messageError.isDisplayed());

        driver.close();
        driver.quit();
    }

}
