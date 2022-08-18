package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CashTransferPage {
    private final By amountSelector = By.id("Amount");
    private final By acceptBtnSelector = By.id("btn_CashTransfer");
    private final By otpSelector = By.id("tvCashtransferOTP");
    private final By acceptOtpBtnSelector = By.id("submitCashTransferWithPIN");
    private final By wrongOTPMessageSelector = By.id("message_error");
    private final WebDriver driver;
    WebDriverWait wait;

    public CashTransferPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement amount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountSelector));
    }

    public WebElement acceptBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(acceptBtnSelector));
    }
    public WebElement otp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(otpSelector));
    }
    public WebElement acceptOtpBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(acceptOtpBtnSelector));
    }
    public WebElement wrongOTPMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wrongOTPMessageSelector));
    }

    public CashTransferPage inputAmount(String amount) {
        amount().clear();
        amount().sendKeys(amount);
        return this;
    }
    public CashTransferPage clickOnAcceptBtn() {
        acceptBtn().click();
        return this;
    }
    public CashTransferPage inputOtp(String otp) {
        otp().clear();
        otp().sendKeys(otp);
        return this;
    }
    public CashTransferPage clickOnAcceptOtpBtn() {
        acceptOtpBtn().click();
        return this;
    }
}
