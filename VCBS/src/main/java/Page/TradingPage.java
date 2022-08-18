package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TradingPage {
    private final By signOutBtnSelector = By.xpath("/html/body/div[1]/form/div[2]/table/tbody/tr/td[15]/input");
    private final By cashTransferBtnSelector = By.cssSelector("[value='Chuyển tiền']");
    private final By corporateActionBtnSelector = By.cssSelector("[value='Thực hiện quyền']");
    private final WebDriver driver;
    WebDriverWait wait;

    public TradingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement signOutBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signOutBtnSelector));
    }
    public WebElement cashTransferBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cashTransferBtnSelector));
    }
    public WebElement corporateActionBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(corporateActionBtnSelector));
    }

    public TradingPage clickOnCashTransferBtn() {
        cashTransferBtn().click();
        return this;
    }
    public TradingPage clickOnCorporateActionBtn() {
        corporateActionBtn().click();
        return this;
    }
}
