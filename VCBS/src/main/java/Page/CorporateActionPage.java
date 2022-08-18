package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CorporateActionPage {
//    private final By symbolSelector = By.id("#gridRightOff_DXFREditorcol3_I");
    private final By symbolSelector = By.xpath("//*[@id=\"gridRightOff_DXFREditorcol3_I\"]");
    private final By registerBtnSelector = By.cssSelector("[value='Đăng ký']");
//    private final By registerBtnSelector = By.xpath("//*[@id=\"gridRightOff_tccell0_9\"]/input");

//    private final By volumeSelector = By.id("#volume");
    private final By remainNumberSelector = By.xpath("//*[@id=\"remainNumberStock\"]");
    private final By volumeSelector = By.xpath("//*[@id=\"volume\"]");
    private final By checkboxAgreeSelector = By.id("checkboxAgree");
    private final By tradingPasswordSelector = By.id("pinAdditionalShare");
    private final By submitBtnSelector = By.id("btOkAdditionalShares");
    private final By messageSelector = By.cssSelector("#successMessageAdditional_shares");
    private final By messageErrorSelector = By.id("message_error");
    private final By okBtnSelector = By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"buttonOK\", \" \" ))]");
    private final By okBtnExceedVolumeSelector = By.cssSelector(".buttonOK");
    private final By updateHistoryBtnSelector = By.id("#updateHistory");
    private final By symbolHistoryBtnSelector = By.id("#ADDITIONAL ISSUED SHARES HISTORY_DXFREditorcol5_I");
    private final By closeBtnPopupInputAmountSelector = By.xpath("//*[@id=\"additionalSharesConfirm\"]/div[5]/input[2]");
    private final By closeBtnSelector = By.cssSelector(".ui-dialog-titlebar-close");
    private final By gridAreaSelector = By.xpath("//*[@id=\"gridRightOff\"]/tbody/tr/td/div[2]");

    private final WebDriver driver;
    WebDriverWait wait;

    public CorporateActionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement symbol() {
        return wait.until(ExpectedConditions.elementToBeClickable(symbolSelector));
    }
    public WebElement registerBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtnSelector));
    }
    public WebElement remainNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(remainNumberSelector));
    }
    public WebElement volume() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(volumeSelector));
    }
    public WebElement checkboxAgree() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxAgreeSelector));
    }
    public WebElement tradingPassword() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tradingPasswordSelector));
    }
    public WebElement submitBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtnSelector));
    }
    public WebElement message() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageSelector));
    }
    public WebElement messageError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageErrorSelector));
    }
    public WebElement okBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(okBtnSelector));
    }
    public WebElement okBtnExceedVolume() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(okBtnExceedVolumeSelector));
    }
    public WebElement updateHistoryBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(updateHistoryBtnSelector));
    }
    public WebElement symbolHistory() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(symbolHistoryBtnSelector));
    }
    public WebElement closeBtn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtnSelector));
    }
    public WebElement closeBtnPopupInputAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(closeBtnPopupInputAmountSelector));
    }
    public WebElement gridArea() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(gridAreaSelector));
    }

    public CorporateActionPage searchSymbol(String symbol) {
        symbol().clear();
        symbol().sendKeys(symbol);
//        symbol().sendKeys(Keys.ENTER);
        return this;
    }
    public CorporateActionPage clickOnRegisterBtn() {
        registerBtn().click();
        return this;
    }
    public CorporateActionPage inputVolume(String volume) {
        volume().clear();
        volume().sendKeys(volume);
        return this;
    }
    public CorporateActionPage clickOnCheckboxAgree() {
        checkboxAgree().click();
        return this;
    }
    public CorporateActionPage inputTradingPassword(String tradingPassword) {
        tradingPassword().clear();
        tradingPassword().sendKeys(tradingPassword);
        return this;
    }
    public CorporateActionPage clickOnSubmitBtn() {
        submitBtn().click();
        return this;
    }
    public CorporateActionPage clickOnOKBtn() {
        okBtn().click();
        return this;
    }
    public CorporateActionPage clickOnOKBtnExceed() {
        okBtnExceedVolume().click();
        return this;
    }
    public CorporateActionPage clickOnUpdateHistoryBtn() {
        updateHistoryBtn().click();
        return this;
    }
    public CorporateActionPage searchSymbolHistory(String symbol) {
        symbolHistory().clear();
        symbolHistory().sendKeys(symbol);
        return this;
    }
    public CorporateActionPage clickOnCloseBtn() {
        closeBtn().click();
        return this;
    }
    public CorporateActionPage ClickOnCloseBtnPopupInputAmount() {
        closeBtnPopupInputAmount().click();
        return this;
    }
    public CorporateActionPage clickOnGridArea() {
        gridArea().click();
        return this;
    }
}
